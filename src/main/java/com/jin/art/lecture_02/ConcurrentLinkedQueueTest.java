package com.jin.art.lecture_02;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author wu.jinqing
 * @date 2017年07月13日
 */
public class ConcurrentLinkedQueueTest {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue();

        queue.add("A");
        queue.add("B");
        queue.add("C");

        System.out.println("size：" + queue.size());

        System.out.println(queue.poll());
        System.out.println("size：" + queue.size());
        System.out.println(queue.peek());
        System.out.println("size：" + queue.size());
    }

}
