package com.jin.art.lecture_02;

/**
 * Created by wujinqing on 17/6/26.
 */
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();

        t1.join();
        System.out.println(t1.isAlive());
        System.out.println(t1.isInterrupted());
    }
}
