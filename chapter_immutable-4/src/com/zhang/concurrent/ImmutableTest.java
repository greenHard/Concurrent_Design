package com.zhang.concurrent;

import java.util.Collections;
import java.util.List;

/**
 * @author zhang yuyang
 * @ClassName: com.zhang.concurrent.ImmutableTest
 * @Description: 不可变对象测试
 * @create 2018/06/12 14:47
 */
public class ImmutableTest {

    private final int age;

    private final String name;

    private final List<String> list;

    public ImmutableTest(int age, String name, List<String> list) {
        this.age = age;
        this.name = name;
        this.list = list;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<String> getList() {
        // 返回一个不可修改的list
        return Collections.unmodifiableList(list);
    }

    @Override
    public String toString() {
        return "ImmutableTest{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", list=" + list +
                '}';
    }
}
