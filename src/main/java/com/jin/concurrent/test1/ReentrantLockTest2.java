package com.jin.concurrent.test1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wu.jinqing
 * @date 2017年06月15日
 */
public class ReentrantLockTest2 {
    public static void main(String[] args) {
        final ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            lock.lock();

            try {
                for (int i = 0; i <= 100; i++)
                {
                    System.out.println("i=" + i);
                }
            }finally {
                lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            lock.lock();

            try {
                for (int k = 0; k <= 100; k++)
                {
                    System.out.println("k=" + k);
                }
            }finally {
                lock.unlock();
            }
        });

        t1.start();
        t2.start();


        lock.lock();

        try {
            for (int j = 0; j <= 100; j++)
            {
                System.out.println("j=" + j);
            }
        }finally {
            lock.unlock();
        }


    }
}
