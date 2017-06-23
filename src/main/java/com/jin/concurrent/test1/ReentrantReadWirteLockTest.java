package com.jin.concurrent.test1;

/**
 * @author wu.jinqing
 * @date 2017年06月23日
 */
public class ReentrantReadWirteLockTest {
    static final int SHARED_SHIFT   = 16;
    // 一个int占32位
    // 将1左移16位
    static final int SHARED_UNIT    = (1 << SHARED_SHIFT);
    static final int MAX_COUNT      = (1 << SHARED_SHIFT) - 1;
    static final int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;

    public static void main(String[] args) {
        System.out.println(SHARED_SHIFT);
        System.out.println(Integer.toBinaryString(SHARED_SHIFT));
        System.out.println(SHARED_UNIT);
        System.out.println(Integer.toBinaryString(SHARED_UNIT));
        System.out.println(MAX_COUNT);
        System.out.println(Integer.toBinaryString(MAX_COUNT));
        System.out.println(EXCLUSIVE_MASK);
        System.out.println(Integer.toBinaryString(EXCLUSIVE_MASK));
    }
}
