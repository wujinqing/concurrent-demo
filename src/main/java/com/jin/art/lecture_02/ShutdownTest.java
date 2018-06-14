package com.jin.art.lecture_02;

import java.util.concurrent.TimeUnit;

/**
 * Created by wujinqing on 17/6/26.
 */
public class ShutdownTest {
    public static void main(String[] args) throws InterruptedException {
        Count t1 = new Count();

        t1.start();

        TimeUnit.SECONDS.sleep(1);

        t1.interrupt();

        Count t2 = new Count();

        t2.start();

        TimeUnit.SECONDS.sleep(1);

        t2.cancel();
    }
}

class Count extends Thread
{
    private volatile boolean on = true;
    private long i;
    @Override
    public void run() {
        while (on && !Thread.currentThread().isInterrupted())
        {
            i++;
        }

        System.out.println("count i = " + i);
    }

    public void cancel()
    {
        on = false;
    }
}