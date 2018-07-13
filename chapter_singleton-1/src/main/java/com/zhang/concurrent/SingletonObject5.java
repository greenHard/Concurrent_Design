package com.zhang.concurrent;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * 单例模式 -懒加载 -枚举
 * -- 创建枚举默认就是线程安全的,
 * -- 创建枚举的时候实例已经创建好了
 */
public class SingletonObject5 {

    private SingletonObject5() {
    }

    private enum Singleton {

        INSTANCE;

        private final SingletonObject5 instance;

        Singleton() {
            instance = new SingletonObject5();
        }

        public SingletonObject5 getInstance() {
            return instance;
        }
    }

    public static SingletonObject5 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100).forEach(i -> new Thread(String.valueOf(i)) {
            @Override
            public void run() {
                Optional.of(SingletonObject5.getInstance()).ifPresent(System.out::println);
            }
        }.start());
    }
}
