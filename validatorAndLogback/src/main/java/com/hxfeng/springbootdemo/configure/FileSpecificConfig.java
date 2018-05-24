package com.hxfeng.springbootdemo.configure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConfigurationProperties(prefix = "myfile")
/**
 * 如果使用prefix指定的时候就不用value注解
 * 如果需要使用注解的话请用完整的引用如 @Value("${myfile.filename}")
 */
//@PropertySource(value = "classpath:application.properties")
public class FileSpecificConfig {
    @Value("${myfile.filename}")
    String fileName;
    @Value("${myfile.filepath}")
    String filePath;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
