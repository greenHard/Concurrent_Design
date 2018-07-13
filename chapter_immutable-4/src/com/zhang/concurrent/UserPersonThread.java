package com.zhang.concurrent;

/**
 * @author zhang yuyang
 * @ClassName: com.zhang.concurrent.UserPersonThread
 * @Description: 使用人物线程类
 * @create 2018/06/12 14:32
 */
public class UserPersonThread extends Thread {
    private Person person;

    public UserPersonThread(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "----" + person.toString());
        }
    }
}
