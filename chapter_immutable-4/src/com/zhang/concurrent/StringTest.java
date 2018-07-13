package com.zhang.concurrent;

/**
 * @author zhang yuyang
 * @ClassName: com.zhang.concurrent.StringTest
 * @Description: String 测试类
 * @create 2018/06/12 14:37
 */
public class StringTest {
    public static void main(String[] args) {
        String s = "Hello";
        String s2 = s.replace("l", "k");
        System.out.println(s.getClass() + " " + s.hashCode());
        // class java.lang.String 69609650
        System.out.println(s2.getClass() + " " + s2.hashCode());
        // class java.lang.String 69608658
    }
}
