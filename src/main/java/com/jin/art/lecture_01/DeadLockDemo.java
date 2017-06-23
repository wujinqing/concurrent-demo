package com.jin.art.lecture_01;

/**
 * Created by wujinqing on 17/6/21.
 */
public class DeadLockDemo {
    public static final String A = "A";
    public static final String B = "B";

    private void deadLock()
    {
        Thread t1 = new Thread(() -> {
            synchronized (A)
            {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (B)
                {
                    System.out.println("1");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (B)
            {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (A)
                {
                    System.out.println("2");
                }
            }
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }
}
