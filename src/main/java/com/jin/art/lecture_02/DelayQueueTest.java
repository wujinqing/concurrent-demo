package com.jin.art.lecture_02;

import java.util.concurrent.DelayQueue;

/**
 * @author wu.jinqing
 * @date 2017年07月13日
 */
public class DelayQueueTest {
    static DelayQueue<DelayedTask> queue = new DelayQueue<>();
    public static void main(String[] args) throws InterruptedException {
        DelayedTask t1 = new DelayedTask("A", 3);

        queue.put(t1);
        System.out.println(t1.START_TIME);
        System.out.println("AAA");
        System.out.println(queue.take());
        System.out.println("END");

        System.out.println(new DelayedTask("B", 3).START_TIME);
    }
}
