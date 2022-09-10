package com.MW.SendFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 发送文件
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 8080)){
            System.out.println("已连接到服务器");
            FileInputStream fileInputStream = new FileInputStream("D:\\JAVA\\Java project\\JavaWeb\\1Socket\\net\\data.txt");
            OutputStream stream = socket.getOutputStream();
            byte[] bytes = new byte[1024];
            int i;
            while ((i=fileInputStream.read(bytes)) != -1){
                stream.write(bytes,0,i);
            }
            fileInputStream.close();
            stream.flush();
        } catch (IOException e) {
            System.out.println("服务器连接失败");
            e.printStackTrace();
        }
    }
}
