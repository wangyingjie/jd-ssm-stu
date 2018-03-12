package com.jd.sync;

import java.util.concurrent.*;

/**
 * @desc
 * @author: wangyingjie1
 * @date: ${date}
 */
public class FutureTaskDemo {

    public static void main(String[] args) throws Exception {

        // 用来接收线程池返回值得对象
        FutureTask<String> task = new FutureTask(new Callable() {
            @Override
            public String call() throws Exception {

                return null;
            }
        });
        task.get();

        ExecutorService executor = Executors.newSingleThreadExecutor();

        ExecutorService executor2 = new ThreadPoolExecutor(5, 10,
                1000, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100));

        // 区别:1、底层都是调用了 execute 方法；2、一个有返回值一个没有返回值
        executor.execute(new Task());

        Future<?> submit = executor.submit(new Task());

    }

    private static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("Hello world");
        }
    }
}
