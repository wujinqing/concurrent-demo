package com.jin.art.lecture_03;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author wu.jinqing
 * @date 2017年07月19日
 */
public class AtomicIntegerArrayTest {
    public static void main(String[] args) {
        int[] is = new int[]{1, 2};

        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(is);

        atomicIntegerArray.set(0, 9);
        System.out.println(atomicIntegerArray.get(0));
        System.out.println(is[0]);
    }
}
