package com.jin.art.lecture_02;

import java.util.concurrent.TimeUnit;

/**
 * Created by wujinqing on 17/6/26.
 */
public class DeadLoopTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted())
            {

            }

            System.out.println("end");
        });

        t1.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.interrupt();
    }



}
