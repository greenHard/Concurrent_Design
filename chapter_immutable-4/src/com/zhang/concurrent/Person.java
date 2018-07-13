package com.zhang.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1. 类需要被final修饰,不能被继承
 * 2. 类中的属性不能修改,使用private final 去修饰(若是引用类型,需返回不可改变对象)
 * 3. 没有set方法存在。
 */
public final class Person {

    private final String name;

    private final String address;

    private final List<String> list;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
        list = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<String> getList() {
        // 需返回一个不可变的集合
        return Collections.unmodifiableList(list);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
