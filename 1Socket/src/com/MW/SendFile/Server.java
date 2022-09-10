package com.MW.SendFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 发送文件
 * 服务端
 */
public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("等待客户端连接...");
            Socket socket = server.accept();
            System.out.println("客户端已连接，IP地址为："+server.getInetAddress().getHostAddress());
            InputStream stream = socket.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\JAVA\\Java project\\JavaWeb\\1Socket\\net\\test.txt");
            byte[] bytes = new byte[1024];
            int i;
            while ((i=stream.read(bytes)) != -1){
                fileOutputStream.write(bytes,0,i);
            }
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
