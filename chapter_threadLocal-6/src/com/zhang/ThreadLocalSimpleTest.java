package com.zhang;

/**
 * @author zhang yuyang
 * @ClassName: com.zhang.ThreadLocalSimpleTest
 * @Description: threadLocal简单测试
 * @create 2018/06/15 16:16
 */
public class ThreadLocalSimpleTest {

    /**
     * threadLocal设置初始值
     */
    private static ThreadLocal<String> threadLocal = new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return "Alex";
        }
    };


    public static void main(String[] args) throws InterruptedException {
        // threadLocal.set("zhang");
        Thread.sleep(1000L);
        String value = threadLocal.get();
        System.out.println(value);
    }
}
