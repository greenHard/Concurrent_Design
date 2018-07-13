package com.zhang;

public interface Future<T> {
    T get() throws InterruptedException;
}
