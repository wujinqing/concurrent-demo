package com.jin.concurrent.test1;

import java.io.ByteArrayOutputStream;

/**
 * @author wu.jinqing
 * @date 2017年06月14日
 */
public class CallStackTest {
    public static void main(String[] args) {
        try {
            throw new Exception("test");
        } catch (Exception e) {
            StringBuffer sb = new StringBuffer();

            for(StackTraceElement t : e.getStackTrace())
            {
                sb.append(t).append("\n");
            }

            System.out.println(sb);
        }
    }
}
