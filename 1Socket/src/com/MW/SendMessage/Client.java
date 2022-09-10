package com.MW.SendMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 发送消息
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 8080);
             Scanner scanner = new Scanner(System.in)){

            System.out.println("已连接到服务器");
            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer.write(scanner.nextLine()+"\n");
            writer.flush();
            System.out.println("等待服务端确认");
            System.out.println(reader.readLine());
        } catch (IOException e) {
            System.out.println("服务器连接失败");
            e.printStackTrace();
        }
    }
}
