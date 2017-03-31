package com.jin.concurrent.collections;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author wu.jinqing
 * @date 2017年03月30日
 */
public class ArrayBlockingQueueTest {
    private static ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(1);

    public static void main(String[] args) throws InterruptedException {
        blockingQueue.put(1);
        blockingQueue.add(2);

    }
}
