package com.jin.concurrent;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wu.jinqing
 * @date 2017年03月24日
 */
public class HashMapTest {

    public static void main(String[] args) throws InterruptedException {
//        final HashMap<String, String> map = new HashMap<String, String>(2);
        final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            map.put(UUID.randomUUID().toString(), "");

                        }

                    }, "ftf" + i).start();

                }

            }

        }, "ftf");

        t.start();
        t.join();
    }

}
