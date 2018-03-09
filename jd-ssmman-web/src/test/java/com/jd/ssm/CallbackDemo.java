package com.jd.ssm;

import sun.misc.VM;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @desc
 * @author: wangyingjie1
 * @date: ${date}
 */
public class CallbackDemo {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(() -> {
            System.out.println("Hello world!");
        });

        System.out.println("ABC");

        executorService.shutdown();


        Optional<String> optional = Optional.of("Hello world");


        System.out.println("===========" + VM.maxDirectMemory());

        System.out.println(Thread.currentThread().getState());
    }

    public interface Callback {

        void callback();


    }

    public class CallbackExecutor {

        private Queue<Callback> callbackQueue = new LinkedList<>();

        public void test(int erewrewrewrewrerewrew, long erewrerwer, String ffsdfdsfdsfdsfdsf, Long dfdsfdsfdsfasfs, Long dfdsfdsfds, Long dfdsfdsfdfdf) {

            int vender = 111;
            System.out.println(vender);
        }

        public void run() {
            callbackQueue.stream().forEach(callback -> callback.callback());
        }

        public void execute(Callback callback) {
            callbackQueue.add(callback);
        }
    }
}
