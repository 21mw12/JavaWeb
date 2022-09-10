package com.MW.WebConnect;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 用浏览器访问
 * 访问http://localhost:8080
 */
public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)){
            System.out.println("等待客户端连接...");
            Socket socket = server.accept();
            System.out.println("客户端已连接，IP地址为："+server.getInetAddress().getHostAddress());
            InputStream stream = socket.getInputStream();
            System.out.println("收到客户端数据：");
            while (true){
                int i = stream.read();
                if(i == -1)break;
                System.out.print((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
