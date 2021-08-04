package com.medsci.hello.spring.boot.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: Arnold
 * @date: 2021/7/29 10:06
 */
public class Test {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
//        scheduledExecutorService.schedule(() -> System.out.println("延迟3秒"), 3, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println("延迟 1 秒后每三秒执行一次"), 1, 3, TimeUnit.SECONDS);
    }
}
