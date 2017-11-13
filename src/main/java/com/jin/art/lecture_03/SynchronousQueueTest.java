package com.jin.art.lecture_03;

import java.util.concurrent.SynchronousQueue;

/**
 * @author wu.jinqing
 * @date 2017年07月20日
 */
public class SynchronousQueueTest {
    static SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();

    public static void main(String[] args) throws InterruptedException {
//        new Thread(() -> {
//            try {
//                synchronousQueue.put("A");
//                synchronousQueue.put("B");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();

//        synchronousQueue.put("B");
//        synchronousQueue.put("C");

//        System.out.println(synchronousQueue.take());
//        System.out.println(synchronousQueue.take());

//        new Thread(() -> {
//            while (true)
//            {
//                try {
//                    System.out.println(synchronousQueue.take());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }).start();

        System.out.println(synchronousQueue.take());
    }
}
