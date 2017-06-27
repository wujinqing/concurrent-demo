package com.jin.art.lecture_02;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.CountDownLatch;

/**
 * Created by wujinqing on 17/6/26.
 */
public class MultiThread {
    public static void main(String[] args) {
        System.out.println("处理器数量: " + Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 100; i++)
        {
            new Thread(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);

        for (ThreadInfo t : threadInfos)
        {
            System.out.println("[" + t.getThreadId() + "]" + t.getThreadName());
        }
    }
}
