package com.jin.art.lecture_01;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author wu.jinqing
 * @date 2017年06月27日
 */
public class WaitNotifyTest {
    private static Object lock = new Object();
    private static boolean flag = true;

    public static void main(String[] args) {
        Thread wait = new Thread(new Wait(), "Waiting");

        wait.start();

        Thread notify = new Thread(new Notify(), "Notify");

        notify.start();
    }
    static class Wait implements Runnable
    {
        @Override
        public void run() {
            synchronized (lock)
            {
                while (flag)
                {
                    System.out.println(Thread.currentThread() + "flag is true. at" + LocalDateTime.now().toString());

                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread() + "flag is false. at" + LocalDateTime.now().toString());
            }
        }
    }

    static class Notify implements Runnable
    {
        @Override
        public void run() {
            synchronized (lock)
            {
                System.out.println(Thread.currentThread() + "hold lock. notify "  + LocalDateTime.now().toString());

                lock.notifyAll();
                flag = false;
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String s = "";
            for (int i = 0; i <= 10000; i++)
            {
               s += i;
            }

            synchronized (lock)
            {
                System.out.println(Thread.currentThread() + "hold lock again. notify "  + LocalDateTime.now().toString());

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}