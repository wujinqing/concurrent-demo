package com.jin.concurrent.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author wu.jinqing
 * @date 2017年03月30日
 */
public class AtomicBooleanTest {
    public static void main(String[] args) {
        AtomicBoolean atomicBoolean = new AtomicBoolean();

        System.out.println(atomicBoolean.get());
    }
}
