package com.jin.art.lecture_01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wujinqing on 17/6/21.
 */
public class ThreadPoolTest {
    public static final ExecutorService exe = Executors.newFixedThreadPool(100);

    public static void main(String[] args) {
        for(int i = 0; i< 1000; i++) {
            exe.execute(() -> {
                System.out.println("ddd");
            });
        }

        while (true)
        {

        }
    }
}
