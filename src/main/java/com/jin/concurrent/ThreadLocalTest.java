package com.jin.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 在每个线程Thread里面有个ThreadLocal.ThreadLocalMap threadLocals变量
 * 1.先在当前线程的threadLocals里面查找是否已经存在ThreadLocal，存在直接返回，没有就创建一个
 *
 * @author wu.jinqing
 * @date 2018年05月10日
 */
public class ThreadLocalTest {
    private static ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal
            = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMddHHmmss"));


    public static void main(String[] args) {
        new Thread(() -> {
            SimpleDateFormat sdf = simpleDateFormatThreadLocal.get();

            System.out.println(sdf.format(new Date()));
        }).start();

//        new Thread(() -> {
//            SimpleDateFormat sdf = simpleDateFormatThreadLocal.get();
//
//            System.out.println(sdf.format(new Date()));
//        }).start();


    }
}
