package com.jd.sync;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @desc: JDK8  异步接口调用测试
 * @author: wangyingjie1
 * @date: 2018/3/16 21:14
 */
public class CompletableFutureTest {

    @Test
    public void testSupplyAsync() throws ExecutionException, InterruptedException {
        CompletableFuture.supplyAsync(() -> {
            System.out.println("===============>" + Thread.currentThread().getName());
            return getData();
        });
        CompletableFuture.supplyAsync(() -> {
            System.out.println("===============>" + Thread.currentThread().getName());
            return getData();
        });
        CompletableFuture.supplyAsync(() -> {
            System.out.println("===============>" + Thread.currentThread().getName());
            return getData();
        });
        CompletableFuture.supplyAsync(() -> {
            System.out.println("===============>" + Thread.currentThread().getName());
            return getData();
        });
        CompletableFuture.supplyAsync(() -> {
            System.out.println("===============>" + Thread.currentThread().getName());
            return getData();
        });
        CompletableFuture.supplyAsync(() -> {
            System.out.println("===============>" + Thread.currentThread().getName());
            return getData();
        });
        CompletableFuture.supplyAsync(() -> {
            System.out.println("===============>" + Thread.currentThread().getName());
            return getData();
        });
        CompletableFuture.supplyAsync(() -> {
            System.out.println("===============>" + Thread.currentThread().getName());
            return getData();
        });
        CompletableFuture.supplyAsync(() -> {
            System.out.println("===============>" + Thread.currentThread().getName());
            return getData();
        });
        CompletableFuture.supplyAsync(() -> {
            System.out.println("===============>" + Thread.currentThread().getName());
            return getData();
        });
        CompletableFuture.supplyAsync(() -> {
            System.out.println("===============>" + Thread.currentThread().getName());
            return getData();
        });
        CompletableFuture.supplyAsync(() -> {
            System.out.println("===============>" + Thread.currentThread().getName());
            return getData();
        });
        CompletableFuture.supplyAsync(() -> {
            System.out.println("===============>" + Thread.currentThread().getName());
            return getData();
        });
        CompletableFuture.supplyAsync(() -> {
            System.out.println("===============>" + Thread.currentThread().getName());
            return getData();
        });
        CompletableFuture.supplyAsync(() -> {
            System.out.println("===============>" + Thread.currentThread().getName());
            return getData();
        });
        CompletableFuture.supplyAsync(() -> {
            System.out.println("===============>" + Thread.currentThread().getName());
            return getData();
        });
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("===============>" + Thread.currentThread().getName());
            return getData();
        });

        System.out.println("**************************");
        System.out.println("**************************" + future.get());
    }

    public String getData() {
        String data = "data";
        System.out.println("==============" + new Random() + "=============");
        return data;
    }

}
