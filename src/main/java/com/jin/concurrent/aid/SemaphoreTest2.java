package com.jin.concurrent.aid;

import java.util.concurrent.Semaphore;

/**
 * 先调用release方法，再调用acquire，
 * acquire参数：permits的值必须等于release方法的调用次数
 *
 * @author wu.jinqing
 * @date 2017年06月20日
 */
public class SemaphoreTest2 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);

        for (int i = 0; i < 10; i++)
        {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("test");
                    semaphore.release();
                }catch (InterruptedException e)
                {

                }
            }).start();
        }
        System.out.println("wait...");
        semaphore.acquire(10);

        System.out.println("end");
    }
}
