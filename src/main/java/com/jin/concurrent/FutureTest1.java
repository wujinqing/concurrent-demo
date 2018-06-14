package com.jin.concurrent;

import java.util.concurrent.*;

/**
 * @author wu.jinqing
 * @date 2018年04月17日
 */
public class FutureTest1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("start");
        ExecutorService executorService = Executors.newFixedThreadPool(5);



        Callable<String> r = () -> {
            Thread.sleep(3000);
            System.out.println("继续");
            return  "hello world";
        };
        Future<String> future = executorService.submit(r);

        String v = null;
        try {
            v = future.get(2000, TimeUnit.MILLISECONDS);

            System.out.println(v);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        Thread.sleep(3000);
        System.out.println("end");
    }
}
