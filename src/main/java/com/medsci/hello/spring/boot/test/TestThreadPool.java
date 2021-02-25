package com.medsci.hello.spring.boot.test;

import java.util.concurrent.*;

/**
 * @description:
 * @author: 学长
 * @date: 2021/2/25 14:05
 */
public class TestThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(3, 5, 1L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 9; i++){
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName() + "======> 在办理业务");;
            });
        }
    }
}
