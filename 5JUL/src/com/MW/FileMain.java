package com.MW;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class FileMain {
    public static void main(String[] args) throws IOException {
        //获取日志管理器
        LogManager manager = LogManager.getLogManager();
        //读取我们自己的配置文件
        manager.readConfiguration(new FileInputStream("test.properties"));

        //再获取日志打印器
        Logger logger = Logger.getLogger(Main.class.getName());
        logger.log(Level.CONFIG, "我是一条日志信息，不会被打印");
        logger.log(Level.WARNING, "我是一条警告信息");
    }
}
