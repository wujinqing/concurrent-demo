package com.jin.concurrent.collections;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wu.jinqing
 * @date 2017年03月31日
 */
public class ConditionTest {
    final ReentrantLock lock;
    private final Condition condition;
    private volatile boolean flag = true;

    public void doSomething() throws InterruptedException {
        lock.lock();

        try
        {
            while (flag) {
                System.out.println("doSomething begin");
                condition.await();
            }

            System.out.println("doSomething");
        }finally {
            lock.unlock();
        }
    }

    public void doAnotherthing() throws InterruptedException {
        lock.lock();

        try
        {
            System.out.println("doAnotherthing begin");
            Thread.sleep(300);
            System.out.println("doAnotherthing");

            condition.signal();
            flag = false;
        }finally {
            lock.unlock();
        }
    }
    public ConditionTest() {
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
    }

    public static void main(String[] args) {
        ConditionTest conditionTest = new ConditionTest();

        Thread thread2 = new Thread(() -> {
            try {
                conditionTest.doAnotherthing();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                conditionTest.doSomething();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread2.start();
        thread3.start();
    }
}
