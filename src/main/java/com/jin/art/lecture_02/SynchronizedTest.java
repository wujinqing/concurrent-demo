package com.jin.art.lecture_02;

/**
 * Created by wujinqing on 17/6/26.
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        synchronized (SynchronizedTest.class)
        {

        }

        m();
    }

    public static synchronized void m()
    {

    }
}
