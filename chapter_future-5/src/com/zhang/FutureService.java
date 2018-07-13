package com.zhang;

import java.util.function.Consumer;

/**
 * @author zhang yuyang
 * @ClassName: com.zhang.FutureService
 * @Description:
 * @create 2018/06/12 15:20
 */
public class FutureService {

    public <T> Future<T> submit(final FutureTask<T> task, final Consumer<T> consumer) {
        // 构造一个假的数据
        AsynFuture<T> asynFuture = new AsynFuture<>();

        // 开启一个线程,执行任务
        new Thread(() -> {
            // 执行方法获取真实的数据
            T result = task.call();

            // 将真实的数据响应给Future
            asynFuture.done(result);

            // 实行回调函数
            consumer.accept(result);
        }).start();

        return asynFuture;
    }
}
