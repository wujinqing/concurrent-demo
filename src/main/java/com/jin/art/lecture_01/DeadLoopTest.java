package com.jin.art.lecture_01;

/**
 * @author wu.jinqing
 * @date 2017年06月28日
 */
public class DeadLoopTest {
    private static int nextIndex(int i, int len) {
        return ((i + 1 < len) ? i + 1 : 0);
    }

    public static void main(String[] args) {
        int len = 10;
        int i = 0;

        for(int k = 0; k < 100; k++)
        System.out.println(i = nextIndex(i, len));
    }
}
