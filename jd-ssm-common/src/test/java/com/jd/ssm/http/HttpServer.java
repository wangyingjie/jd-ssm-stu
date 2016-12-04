package com.jd.ssm.http;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * Created by wangyingjie1 on 2016/12/4.
 *
 * 浏览器可以直接通过访问：http://localhost:8080/  即可将请求发送到服务端
 */
public class HttpServer {

    public static void main(String[] args) {

        try {
            final ServerSocketChannel ssc = ServerSocketChannel.open();
            // 服务端绑定 8080 端口
            ssc.socket().bind(new InetSocketAddress(8080));

            // 设置为非阻塞模式
            ssc.configureBlocking(false);

            // 为ssc注册 selector
            final Selector selector = Selector.open();

            ssc.register(selector, SelectionKey.OP_ACCEPT);

            // 创建 handler 处理器
            //final Handler handler = new Handler(1024);

            while (true) {

                //等待请求，每次等待 3s 钟，超过 3s 钟继续向下运行，如果不传入0或者不传入则将一直阻塞
                if (selector.select(3000) == 0) {

                    System.out.println("等待请求超时……………………………………………………");
                    continue;
                }

                System.out.println("请求处理Handler………………………………………………");

                final Iterator<SelectionKey> iteratorKey = selector.selectedKeys().iterator();

                while (iteratorKey.hasNext()) {

                    final SelectionKey key = iteratorKey.next();

                    // 启动新线程处理 SelectionKey
                    new Thread(new HttpHandler(key)).run();

                    // 处理完后，从待处理的 SelectionKey 迭代器中移除当前所使用的key
                    iteratorKey.remove();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }


    }


    // 流处理对象
    private static class HttpHandler implements Runnable {
        private int bufferSize = 1024;
        private String localCharset = "UTF-8";
        private SelectionKey key;


        public HttpHandler() {
        }

        public HttpHandler(SelectionKey key) {
            this.key = key;
        }

        public HttpHandler(int bufferSize) {
            this.bufferSize = bufferSize;
        }

        public HttpHandler(String localCharset) {
            this.localCharset = localCharset;
        }

        public HttpHandler(int bufferSize, String localCharset) {
            this.bufferSize = bufferSize;
            this.localCharset = localCharset;
        }


        //
        public void handleAccpet() {
            try {

                SocketChannel sc = ((ServerSocketChannel) key.channel()).accept();

                sc.configureBlocking(false);

                //allocate vi. 分配；指定
                sc.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void handleRead() throws IOException {
            final SocketChannel sc = (SocketChannel) key.channel();

            // 获取buffer并重置
            ByteBuffer buffer = (ByteBuffer) key.attachment();
            buffer.clear();

            if (sc.read(buffer) == -1) {
                sc.close();
            } else {

                //将buffer转换为读状态
                buffer.flip();
                final String msg = Charset.forName(localCharset).newDecoder().decode(buffer).toString();
                System.out.println("NIOserver received msg===========>" + msg);


                final String[] requestMsg = msg.split("\r\n");
                for (String sp : requestMsg) {
                    System.out.println("sp=====>" + sp);

                    // 遇到空行说明报文已经打印完
                    if (sp.isEmpty()) {
                        break;
                    }
                }

                //String retMsg = "send client " + msg;

                final String[] firstLine = requestMsg[0].split(" ");

                System.out.println();

                System.out.println("Method：\t" + firstLine[0]);
                System.out.println("url:\t" + firstLine[1]);
                System.out.println("Http Version:\t" + firstLine[2]);

                System.out.println();

                StringBuilder sb = new StringBuilder();
                sb.append("HTTP/1.1 200 OK\r\n"); //响应报文首行， 200 表示处理成功
                sb.append("Content-Type: text/html;charset=" + localCharset + "\r\n");//报文头结束后加一个空行

                sb.append("\r\n");

                sb.append("<html><head><title>显示报文</title></head><body>接收到请求报文是：<br/>");
                for (String s : requestMsg) {
                    sb.append(s + "<br/>");
                }
                sb.append("</body>ddddddddddddddddddddddddddddddddddddddddd</html>");

                System.out.println("sb=====" + sb);

                //返回客户端数据
                buffer = ByteBuffer.wrap(sb.toString().getBytes(localCharset));
                sc.write(buffer);

                sc.close();

            }
        }

        @Override
        public void run() {
            try {

                // 接受到连接请求
                if (key.isAcceptable()) {
                    handleAccpet();
                }

                // 读数据
                if (key.isReadable()) {
                    handleRead();
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }
}
