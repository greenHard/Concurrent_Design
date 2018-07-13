package com.zhang;

/**
 * @author zhang yuyang
 * @ClassName: com.zhang.AsynFuture
 * @Description: 异步Future
 * @create 2018/06/12 15:21
 */
public class AsynFuture<T> implements Future<T> {

    private volatile boolean done = false;

    private T result;

    public void done(T result) {
        synchronized (this) {
            this.result = result;
            this.done = true;
            this.notifyAll();
        }
    }

    @Override
    public T get() throws InterruptedException {
        synchronized (this) {
            while (!done) {
                this.wait();
            }
        }
        return result;
    }
}



