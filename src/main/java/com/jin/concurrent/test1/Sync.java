package com.jin.concurrent.test1;

import java.util.concurrent.Semaphore;

/**
 * @author wu.jinqing
 * @date 2017年06月13日
 */
public class Sync {
    public static void main(String[] args) {
        final Sync run = new Sync();
        final Semaphore done = new Semaphore(0);

        System.out.println("S");
        new Thread(() -> {run.x(); done.release();}).start();
        new Thread(() -> {run.y(); done.release();}).start();
        new Thread(() -> {run.z(); done.release();}).start();

        try {
            done.acquire(3);
        } catch (InterruptedException e) {

        }

        System.out.println("E");


    }

    public synchronized void x() {
        System.out.println("x");
        delay();
    }

    public synchronized void y() {
        System.out.println("y");
        delay();
    }

    public void z() {
        System.out.println("z");
        delay();
    }

    void delay()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
    }
}
