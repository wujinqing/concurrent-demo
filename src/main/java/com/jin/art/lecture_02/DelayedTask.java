package com.jin.art.lecture_02;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * @author wu.jinqing
 * @date 2017年07月13日
 */
public class DelayedTask implements Delayed {
    public static final long START_TIME = System.nanoTime();
    private String name;
    private volatile long second;
    private volatile long basetime;
    private volatile boolean times;// getDelay的调用次数

    public DelayedTask(String name, long second) {
        this.name = name;
        this.second = TimeUnit.SECONDS.toNanos(second);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        if(!times) {
            basetime = System.nanoTime();
            times = true;
        }

        long left = System.nanoTime() - basetime;

        return second - left;
    }

    public static void main(String[] args) {
        TimeUnit unit = NANOSECONDS;


    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
