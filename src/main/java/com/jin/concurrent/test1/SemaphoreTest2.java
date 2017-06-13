package com.jin.concurrent.test1;

import java.util.concurrent.Semaphore;

/**
 * @author wu.jinqing
 * @date 2017年06月13日
 */
public class SemaphoreTest2 {
    private static final Semaphore semaphore = new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("111");


        System.out.println("222");
        semaphore.release();
        System.out.println("333");
        semaphore.isFair();
    }
}
