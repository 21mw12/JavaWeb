package com.MW;

import java.io.IOException;
import java.util.logging.*;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class.getName());

        //添加输出到本地文件
        FileHandler fileHandler = null;	//创建文件处理器，输出到test.log文件
        try {
            fileHandler = new FileHandler("test.log", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileHandler.setFormatter(new SimpleFormatter());
        fileHandler.setLevel(Level.WARNING);	//设置处理器级别
        logger.addHandler(fileHandler);		//向日志打印前添加处理器

        //修改日志级别
        logger.setLevel(Level.CONFIG);
        //不使用父日志处理器
        logger.setUseParentHandlers(false);
        //使用自定义日志处理器
        ConsoleHandler handler = new ConsoleHandler();	//创建控制台数据处理器
        handler.setLevel(Level.CONFIG);	//设置处理器级别
        logger.addHandler(handler);		//向日志打印前添加处理器

        logger.log(Level.SEVERE, "严重的错误", new IOException("我就是错误"));
        logger.log(Level.WARNING, "警告的内容");
        logger.log(Level.INFO, "普通的信息");
        logger.log(Level.CONFIG, "级别低于普通信息");
    }
}
