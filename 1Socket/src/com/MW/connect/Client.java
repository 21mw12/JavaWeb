package com.MW.connect;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 连接
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 8080)){
            System.out.println("已连接到服务器");
        } catch (IOException e) {
            System.out.println("服务器连接失败");
            e.printStackTrace();
        }
    }
}
