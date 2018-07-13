package com.zhang;

import java.util.LinkedList;

/**
 * @author zhang yuyang
 * @ClassName: com.zhang.RequestQueue
 * @Description: 请求队列
 * @create 2018/06/15 15:55
 */
public class RequestQueue {

    private final LinkedList<Request> queue = new LinkedList<>();

    public Request getRequest() {
        synchronized (queue) {
            if (queue.size() <= 0) {

            }
        }
    }
}
