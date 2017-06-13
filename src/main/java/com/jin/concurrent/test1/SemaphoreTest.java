package com.jin.concurrent.test1;

import java.util.concurrent.Semaphore;

/**
 * @author wu.jinqing
 * @date 2017年06月13日
 */
public class SemaphoreTest {
    private static final Semaphore semaphore = new Semaphore(2);
    private static int count = 1;

    public static void main(String[] args) {
        for(int i = 0; i <= 100; i++)
        {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(count++);
                    semaphore.release();
                }catch (InterruptedException ex)
                {

                }

            }).start();
        }
    }
}
