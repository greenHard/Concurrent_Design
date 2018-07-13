package com.zhang.concurrent;

/**
 * 单例模式 - 懒加载 - 双重检查锁
 * -- 由于JVM 对编译器和运行期的优化,可能会导致空指针异常
 * -- 添加volatile关键字,但是这样会影响系统的性能
 */
public class SingletonObject3 {

    private static volatile SingletonObject3 instance;

    private SingletonObject3() {
    }

    /**
     * 第二种解决方式
     * 双重检查锁  -- double check
     */
    public static SingletonObject3 getInstance() {
        if (null == instance) {
            synchronized (SingletonObject3.class) {
                if (null == instance) {
                    instance = new SingletonObject3();
                }
            }
        }
        return SingletonObject3.instance;
    }
}
