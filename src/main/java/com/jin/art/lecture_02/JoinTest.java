package com.jin.art.lecture_02;

import java.util.concurrent.TimeUnit;

import static com.jin.concurrent.test1.ShiftTest.s;

/**
 * Created by wujinqing on 17/6/27.
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread prev = Thread.currentThread();

        for(int i = 0; i < 10; i++)
        {
            Thread thread = new Thread(new Domino(prev), "Thread-" + i);

            thread.start();
            prev = thread;
        }

        TimeUnit.SECONDS.sleep(3);

        System.out.println(Thread.currentThread().getName() + " =terminate.");
    }

    static class Domino implements Runnable
    {
        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " -terminate.");
        }
    }
}
