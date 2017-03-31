package com.jin.concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wu.jinqing
 * @date 2017年03月15日
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();

        String oldValue = map.putIfAbsent("zhangsan", "90");

        System.out.println(oldValue);

        oldValue = map.putIfAbsent("zhangsan", "100");

        System.out.println(oldValue);

        oldValue = map.putIfAbsent("zhangsan", "50");

        System.out.println(oldValue);



    }
}
