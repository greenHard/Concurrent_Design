package com.zhang.concurrent;

/**
 * @author zhang yuyang
 * @ClassName: com.zhang.concurrent.ImmutablePerformaceTest
 * @Description: 不可变对象性能测试
 * @create 2018/06/12 14:49
 */
public class ImmutablePerformaceTest {

    public static void main(String[] args) {
        // 单线程情况
        // Elapsed time 7324 sync
        // Elapsed time 7076 immutable
        long startTimestamp = System.currentTimeMillis();
        // SyncObj syncObj = new SyncObj();
        // syncObj.setName("zhang");
        ImmutableObj immutableObj = new ImmutableObj("zhang");
        for (long i = 0L; i < 1000000L; i++) {
            System.out.println(immutableObj);
            // System.out.println(syncObj.toString());
        }
        long endTimestamp = System.currentTimeMillis();
        System.out.println("Elapsed time" + (endTimestamp - startTimestamp));
    }
}

final class ImmutableObj {
    private final String name;

    public ImmutableObj(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ImmutableObj{" +
                "name='" + name + '\'' +
                '}';
    }
}


class SyncObj {
    private String name;

    public synchronized void setName(String name) {
        this.name = name;
    }

    @Override
    public synchronized String toString() {
        return "SyncObj{" +
                "name='" + name + '\'' +
                '}';
    }
}
