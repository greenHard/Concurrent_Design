package com.zhang.concurrent;

/**
 * 单例模式 -懒加载 - 静态内部类
 * -- InstanceHolder
 */
public class SingletonObject4 {

    private SingletonObject4() {
    }

    /**
     * 静态内部类只会加载一次,而且只在调用的时候才会去加载
     */
    private static class InstanceHolder {
        private static final SingletonObject4 instance = new SingletonObject4();
    }

    public static SingletonObject4 getInstance() {
        return InstanceHolder.instance;
    }
}
