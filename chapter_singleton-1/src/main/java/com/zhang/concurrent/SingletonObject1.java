package com.zhang.concurrent;

/**
 * 单例模式-饿汉式
 *      -- 不存在线程安全问题
 *      -- 不能进行懒加载,长期占用内存,对内存有一定的损耗
 */
public class SingletonObject1 {

    private static SingletonObject1  instance= new SingletonObject1();

    private SingletonObject1(){}

    public SingletonObject1 getInstance(){
        return SingletonObject1.instance;
    }
}
