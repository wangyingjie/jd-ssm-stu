package com.jd.ssm.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * Created by wangyingjie1 on 2016/12/4.
 */
public class NIOServer {

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
            final Handler handler = new Handler(1024);

            while (true) {

                //等待请求，每次等待 3s 钟，超过 3s 钟继续向下运行，如果不传入0或者不传入则将一直阻塞
                if (selector.select(3000) == 0) {

                    System.out.println("等待请求超时……………………………………………………");
                    continue;
                }

                System.out.println("请求处理Handler………………………………………………");

                final Iterator<SelectionKey> iteratorKey = selector.selectedKeys().iterator();

                while (iteratorKey.hasNext()) {

                    final SelectionKey nextKey = iteratorKey.next();

                    // 接受到连接请求
                    if (nextKey.isAcceptable()) {
                        handler.handleAccpet(nextKey);
                    }

                    // 读数据
                    if (nextKey.isReadable()) {
                        handler.handleRead(nextKey);
                    }

                    iteratorKey.remove();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }


    }


    // 流处理对象
    private static class Handler {
        private int bufferSize = 1024;
        private String localCharset = "UTF-8";

        public Handler() {
        }

        public Handler(int bufferSize) {
            this.bufferSize = bufferSize;
        }

        public Handler(String localCharset) {
            this.localCharset = localCharset;
        }

        public Handler(int bufferSize, String localCharset) {
            this.bufferSize = bufferSize;
            this.localCharset = localCharset;
        }


        //
        public void handleAccpet(SelectionKey selectionKey) {
            try {

                SocketChannel sc = ((ServerSocketChannel) selectionKey.channel()).accept();

                sc.configureBlocking(false);

                //allocate vi. 分配；指定
                sc.register(selectionKey.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void handleRead(SelectionKey selectionKey) throws IOException {
            final SocketChannel sc = (SocketChannel) selectionKey.channel();

            // 获取buffer并重置
            ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
            buffer.clear();

            if (sc.read(buffer) == -1) {
                sc.close();
            } else {

                //将buffer转换为读状态
                buffer.flip();
                final String msg = Charset.forName(localCharset).newDecoder().decode(buffer).toString();
                System.out.println("NIOserver received msg===========>" + msg);

                String retMsg = "send client " + msg;

                //返回客户端数据
                buffer = ByteBuffer.wrap(retMsg.getBytes(localCharset));
                sc.write(buffer);

                sc.close();

            }
        }
    }
}
