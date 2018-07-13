package com.zhang.concurrent;

import java.util.stream.IntStream;

/**
 * @author zhang yuyang
 * @ClassName: com.zhang.concurrent.ImmutableClient
 * @Description: 不可变对象测试类
 * @create 2018/06/12 14:32
 */
public class ImmutableClient {

    public static void main(String[] args) {
        // 共享数据
        Person person = new Person("ZHANG", "WUHU");

        IntStream.range(0, 5).forEach(i -> new UserPersonThread(person).start());
    }
}
