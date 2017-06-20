package com.jin.concurrent.aid;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;

/**
 * 只要Exchanger拿到两个数据就会把他们交换
 *
 * @author wu.jinqing
 * @date 2017年06月20日
 */
public class ExchangerTest {
    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread t1 = new Thread(() -> {
            try {
                countDownLatch.await();
                String s = exchanger.exchange("T1");
                System.out.println("T1: " + s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                countDownLatch.await();
                String s = exchanger.exchange("T2");
                System.out.println("T2: " + s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                countDownLatch.await();
                String s = exchanger.exchange("T3");
                System.out.println("T3: " + s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t4 = new Thread(() -> {
            try {
                countDownLatch.await();
                String s = exchanger.exchange("T4");
                System.out.println("T4: " + s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        Thread.sleep(300);

        countDownLatch.countDown();


    }
}
