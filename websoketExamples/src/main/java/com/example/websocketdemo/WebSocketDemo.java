package com.example.websocketdemo;


import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

@ServerEndpoint(value = "/websocket/chat")
public class WebSocketDemo {

    //private static final Log log = LogFactory.getLog(ChatAnnotation.class);

    private static final String GUEST_PREFIX = "Guest";
    private static final AtomicInteger connectionIds = new AtomicInteger(0);
    private static final Set<WebSocketDemo> connections = new CopyOnWriteArraySet<>();

    private final String nickname;
    private Session session;

    public WebSocketDemo() {
        nickname = GUEST_PREFIX + connectionIds.getAndIncrement();
    }

    //建立连接
    @OnOpen
    public void start(Session session) {
        this.session = session;
        connections.add(this);
        String message = String.format("* %s %s", nickname, "has joined.");
        System.out.println(message);
    }

    //接受消息
    @OnMessage
    public void incoming(String message) {
        System.out.println(message.toString());
        //broadcast(filteredMessage);
        broadcast(message.toString());
    }

    //客户端关闭了连接
    @OnClose
    public void end() {
        connections.remove(this);
        String message = String.format("* %s %s", nickname, "has disconnected.");
        System.out.println(message);
        //broadcast(message);
    }

    //WebSocket服务出错
    @OnError
    public void onError(Throwable t) throws Throwable {
        //log.error("Chat Error: " + t.toString(), t);
    }

    private static void broadcast(String msg) {
        for (WebSocketDemo client : connections) {
            try {
                synchronized (client) {
                    client.session.getBasicRemote().sendText(msg);
                }
            } catch (IOException e) {
                //log.debug("Chat Error: Failed to send message to client", e);
                connections.remove(client);
                try {
                    client.session.close();
                } catch (IOException e1) {
                    // Ignore
                }
                String message = String.format("* %s %s",
                        client.nickname, "has been disconnected.");
                broadcast(message);
            }
        }
    }
}