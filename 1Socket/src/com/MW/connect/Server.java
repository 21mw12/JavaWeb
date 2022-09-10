package com.MW.connect;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 连接
 * 服务端
 */
public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)){
            System.out.println("等待客户端连接...");
            //当没有客户端连接时，线程会阻塞，直到有客户端连接
            Socket socket = server.accept();
            System.out.println("客户端已连接，IP地址为："+server.getInetAddress().getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
