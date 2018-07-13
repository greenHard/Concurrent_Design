package com.zhang.concurrent;

/**
 * @author zhang yuyang
 * @ClassName: com.zhang.concurrent.VolatileTest2
 * @Description: vliatile 能保证原子性么?
 * @create 2018/05/17 14:33
 */
public class VolatileTest2 {

    private static volatile int inc = 0;

    public void increase() {
        inc++;
    }


    public static void main(String[] args) {

        final VolatileTest2 volatileTest2 = new VolatileTest2();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++)
                    volatileTest2.increase();
            }).start();
        }

        // 保证前面的线程都执行完
        if (Thread.activeCount() > 1) {
            Thread.yield();
        }
        // 结果是一个小于10000的数,每次运行都可能不一样
        System.out.println(inc);

    }
}
