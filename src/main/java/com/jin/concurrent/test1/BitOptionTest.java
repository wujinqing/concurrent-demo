package com.jin.concurrent.test1;

/**
 * Java提供的位运算符有：左移( << )、右移( >> ) 、无符号右移( >>> ) 、
 * 位与( & ) 、位或( | )、位非( ~ )、位异或( ^ )，除了位非( ~ )是一元操作符外，其它的都是二元操作符。
 *
 * 位与：第一个操作数的的第n位于第二个操作数的第n位如果都是1，那么结果的第n为也为1，否则为0
 * 位或操作：第一个操作数的的第n位于第二个操作数的第n位 只要有一个是1，那么结果的第n为也为1，否则为0
 * 位异或：第一个操作数的的第n位于第二个操作数的第n位 相反，那么结果的第n为也为1，否则为0
 * 位非：操作数的第n位为1，那么结果的第n位为0，反之。
 *
 * @author wu.jinqing
 * @date 2017年06月23日
 */
public class BitOptionTest {
    public static final int X = 0b00000000000000000000000000000101;
    public static final int Y = 0b00000000000000000000000000000011;

    public static String toBinaryString(int i)
    {
        String s = Integer.toBinaryString(i);

        int len = 32 - s.length();

        if(len > 0)
            for(int k = 0; k < len; k++)
            {
                s = "0" + s;
            }

        return s;
    }

    public static void op()
    {
        System.out.println("X=" + toBinaryString(X));
        System.out.println("Y=" + toBinaryString(Y));
        System.out.println("&=" + toBinaryString(X & Y));
        System.out.println("|=" + toBinaryString(X | Y));
        System.out.println("^=" + toBinaryString(X ^ Y));
        System.out.println("~=" + toBinaryString(~X));
    }

    public static void main(String[] args) {
        op();



    }
}
