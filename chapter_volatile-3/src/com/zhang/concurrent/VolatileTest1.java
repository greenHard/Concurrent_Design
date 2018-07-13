package com.zhang.concurrent;

/**
 * @author zhang yuyang
 * @ClassName: com.zhang.concurrent.VolatileTest1
 * @Description: volatile 关键字测试Demo
 * @create 2018/05/17 11:24
 */
public class VolatileTest1 {

    private static volatile int INIT_VALUE = 0;

    private static final int MAX_VALUE = 50;

    public static void main(String[] args) {
        // 开启一个读线程
        new Thread(() -> {
            int localValue = INIT_VALUE;
            while (localValue < MAX_VALUE) {
                if (localValue != INIT_VALUE) {
                    System.out.printf("The value updated to [%d]\n", INIT_VALUE);
                    localValue = INIT_VALUE;
                }
            }
        }, "read").start();

        // 开启一个更新线程
        new Thread(() -> {
            int localValue = INIT_VALUE;
            while (localValue < MAX_VALUE) {
                System.out.printf("Update the value to [%d]\n", ++localValue);
                INIT_VALUE = localValue;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "update").start();
    }
}
