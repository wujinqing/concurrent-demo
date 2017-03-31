package com.jin.concurrent.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author wu.jinqing
 * @date 2017年03月30日
 */
public class AtomicIntegerArrayTest {
    public static void main(String[] args) {
        AtomicIntegerArray integerArray = new AtomicIntegerArray(10);
        integerArray.set(0, 10);

        System.out.println(integerArray.get(0));
    }
}
