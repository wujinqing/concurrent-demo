package com.jin.concurrent.test1;

/**
 * @author wu.jinqing
 * @date 2017年06月14日
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("A");

        Thread t1 = new Thread(() -> {
            System.out.println("B");
            System.out.println(Thread.currentThread().getId());
            System.out.println(Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("C0");
        t1.start();
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getName());
        System.out.println("C");

        t1.join();

        System.out.println("D");
        System.out.println("E");
        System.out.println("F");

        Thread.currentThread().getStackTrace();

        StringBuffer sb = new StringBuffer();


        for(StackTraceElement t : Thread.currentThread().getStackTrace())
        {
            sb.append(t).append("\n");
        }

        System.out.println(sb);
    }
}
