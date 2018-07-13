package com.zhang;

import java.util.concurrent.Callable;

/**
 * Future -> 代表的是未来的凭据
 * FutureTask -> 将调用逻辑进行隔离
 * FutureService -> 桥接 Future和FutureTask
 */
public class SyncInvoke {

    public static void main(String[] args) throws InterruptedException {

        // 1. 创建类
        FutureService futureService = new FutureService();

        // 2. 调用方法
        Future<String> future = futureService.submit(() -> {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "FINISH";
        }, System.out::println);

        System.out.println("============");
        System.out.println("do  other thing...");
        Thread.sleep(1000L);
        System.out.println("============");
    }

    /**
     * 有么有这样一种机制,开始调用立马给我返回结果。
     * 然后在我需要这个结果的时候再去拿数据。
     */
    public static String get() throws InterruptedException {
        //  这里是一个非常耗时的时间
        Thread.sleep(100000);
        return "FINISH";
    }
}
