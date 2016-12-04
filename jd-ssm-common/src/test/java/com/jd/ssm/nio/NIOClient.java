package com.jd.ssm.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by wangyingjie1 on 2016/12/4.
 */
public class NIOClient {

    public static void main(String[] args) {

        String msg = "NIOClient say: Hello World";

        try {
            // 客户端监听服务端的端口
            Socket socket = new Socket("127.0.0.1", 8080);

            final PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println(msg);
            printWriter.flush();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            final String line = bufferedReader.readLine();

            System.out.println("line================>" + line);

            closeResource(socket, printWriter, bufferedReader);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    // 关闭资源
    private static void closeResource(Socket socket, PrintWriter printWriter, BufferedReader bufferedReader) throws IOException {
        printWriter.close();
        bufferedReader.close();
        socket.close();
    }
}
