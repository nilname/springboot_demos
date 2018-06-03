package com.hxfeng.springbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hxfeng.springbootdemo")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

/**
 * 下面代码可以设置上传文件的大小限制
 * 也可以通过配置文件来设置不同版本的springboot设置的方式不一样。
 *
 # Max file size.
 spring.servlet.multipart.max-file-size=500MB
 # Max request size.
 spring.servlet.multipart.max-request-size=50000MB
 spring.servlet.multipart.enabled=true

 */

//	@Bean
//	public MultipartConfigElement multipartConfigElement() {
//		MultipartConfigFactory factory = new MultipartConfigFactory();
//		//单个文件最大
//		factory.setMaxFileSize("10240KB"); //KB,MB
//		/// 设置总上传数据总大小
//		factory.setMaxRequestSize("102400KB");
//		return factory.createMultipartConfig();
//	}
}

