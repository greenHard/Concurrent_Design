package com.zhang.concurrent;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * wait set
 * Java的每一个对象除了有一个相关的monitor以外（用做synchronized lock）
 * 还有一个相关的wait set，用以存放处于WAITING状态的线程
 * <p>
 * 1. wait set是线程的集合
 * 2. 当Java对象创建的时候，其wait set是空的。对于wait set操作(将线程加入或移出wait set)都是原子操作
 * 3. 对于wait set的操作(加入或移出)，而且只能通过Object.wait，Object.notify，Object.notifyAll这三个操作来进行。
 * 当线程执行到Object.wait指令后，就会进入到wait set集合中；而执行到Object.notify,Object.notifyAll指令后，
 * 则通知处于wait set中的线程，条件满足了。
 */
public class WaitSet {

    private static void work() {
        synchronized (LOCK) {
            Optional.of("Begin....").ifPresent(System.out::println);
            try {
                Optional.of("Thread will coming....").ifPresent(System.out::println);
                LOCK.wait();
                Optional.of("Thread will out....").ifPresent(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static final Object LOCK = new Object();

    /**
     * 1.所有的对象都会有一个wait set,用来存放调用了该对象wait方法之后进入block状态线程
     * 2.线程被notify之后，不一定立即得到执行
     * 3.线程从wait set中被唤醒顺序不一定是FIFO.
     * 4.线程被唤醒后，必须重新获取锁
     */
    public static void main(String[] args) throws InterruptedException {
        new Thread() {
            @Override
            public void run() {
                work();
            }
        }.start();

        Thread.sleep(1000);

        synchronized (LOCK) {
            LOCK.notify();
        }
    }
       /* IntStream.rangeClosed(1, 10).forEach(i -> new Thread(String.valueOf(i)) {
            @Override
            public void run() {
                synchronized (LOCK) {
                    try {
                        Optional.of(Thread.currentThread().getName() + " will come to wait set..").ifPresent(System.out::println);
                        LOCK.wait();
                        Optional.of(Thread.currentThread().getName() + " will leave to wait set..").ifPresent(System.out::println);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start());

        Thread.sleep(3000);

        IntStream.rangeClosed(1, 10).forEach(i -> {
            synchronized (LOCK) {
                LOCK.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }*/
}
