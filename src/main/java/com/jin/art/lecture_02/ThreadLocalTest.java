package com.jin.art.lecture_02;

import java.util.concurrent.TimeUnit;

/**
 * Created by wujinqing on 17/6/27.
 */
public class ThreadLocalTest {
    public static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<>();

    public static final void begin()
    {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end()
    {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest.begin();

        TimeUnit.SECONDS.sleep(5);

        System.out.println("Cost: " + ThreadLocalTest.end() + " mills");
    }
}
