package com.zhang;

import java.util.Random;

/**
 * @author zhang yuyang
 * @ClassName: com.zhang.ThreadLocalComplexTest
 * @Description: ThreadLocal 复杂测试
 * @create 2018/06/15 16:21
 */
public class ThreadLocalComplexTest {
    private final static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private final static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            threadLocal.set("Thread - t1");
            try {
                Thread.sleep(random.nextInt(100));
                System.out.println(Thread.currentThread().getName() + " "+threadLocal.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            threadLocal.set("Thread - t2");
            try {
                Thread.sleep(random.nextInt(100));
                System.out.println(Thread.currentThread().getName() + " "+threadLocal.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println();
        System.out.println(Thread.currentThread().getName() + " "+threadLocal.get());
    }
}
