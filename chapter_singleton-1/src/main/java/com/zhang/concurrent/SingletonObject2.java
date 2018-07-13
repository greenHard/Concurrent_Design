package com.zhang.concurrent;

/**
 * 单例模式- 懒加载 - 方法加锁
 *      -- 默认不加synchronized会导致线程安全问题
 */
public class SingletonObject2 {

    private static SingletonObject2 instance;

    private  SingletonObject2() {
    }

    /**
     * 第一种解决方式
     * 方法上添加synchronized
     */
    public synchronized  static SingletonObject2 getInstance() {
        // 如果为null 才创建对象,节约内存
        if (null == instance) {
            instance = new SingletonObject2();
        }
        return SingletonObject2.instance;
    }
}
