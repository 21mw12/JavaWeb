package com.MW.SendMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 发送消息
 * 服务端
 */
public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)){

            System.out.println("等待客户端连接...");
            Socket socket = server.accept();    // 等待客户端连接
            System.out.println("客户端已连接，IP地址为："+server.getInetAddress().getHostAddress());
            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(reader.readLine());
            writer.write("收到\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
