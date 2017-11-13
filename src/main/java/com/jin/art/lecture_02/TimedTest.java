package com.jin.art.lecture_02;

/**
 * Created by wujinqing on 17/6/27.
 */
public class TimedTest {
    public synchronized String get(long mills) throws InterruptedException
    {
        long future = System.currentTimeMillis() + mills;
        long remaining = mills;
        String result = null;
        while ( result == null && remaining > 0)
        {
            wait(remaining);

            remaining = future - System.currentTimeMillis();
        }

        return "zhang san ";

    }

    public static void main(String[] args) throws InterruptedException {
        String s = new TimedTest().get(1000);

        System.out.println(s);
    }
}
