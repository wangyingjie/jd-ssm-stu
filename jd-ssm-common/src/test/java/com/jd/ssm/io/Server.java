package com.jd.ssm.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by wangyingjie1 on 2016/12/4.
 * <p>
 * ServerSocket 服务端测试类
 */
public class Server {
    private final static int PORT = 8080;

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);

            //监听客户端的 socket 请求  accept 方法属于阻塞方法，程序会一直在此处处于等待状态
            final Socket socket = serverSocket.accept();

            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            final String line = bufferedReader.readLine();

            System.out.println(" receive form client msg=======> " + line);

            final PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            printWriter.println("send client data =" + line);

            printWriter.flush();

            closeResource(serverSocket, socket, bufferedReader, printWriter);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 关闭资源
    private static void closeResource(ServerSocket serverSocket, Socket socket, BufferedReader bufferedReader, PrintWriter printWriter) throws IOException {
        printWriter.close();

        bufferedReader.close();

        socket.close();

        serverSocket.close();
    }
}
