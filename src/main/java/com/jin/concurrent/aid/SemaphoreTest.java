package com.jin.concurrent.aid;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 通过构造方法参数permits，控制并发访问的数量，还可以指定是公平锁策略还是非公平锁策略,默认是非公平锁
 * 先调用acquire获取锁
 *
 * 再调用release释放锁
 * 与下面这种方式的不同：
 * @see SemaphoreTest2
 *
 * @author wu.jinqing
 * @date 2017年06月19日
 */
public class SemaphoreTest {
    private static final int N = 10;
    static AtomicInteger k = new AtomicInteger(0);

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(N);

        for(int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    Thread.sleep(1000);
                    System.out.println("k: " + k.getAndIncrement());
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
