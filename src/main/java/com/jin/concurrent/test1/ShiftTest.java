package com.jin.concurrent.test1;

/**
 * java中有三种移位运算符：
 *
 * Java提供的位运算符有：左移( << )、右移( >> ) 、无符号右移( >>> ) 、位与( & ) 、位或( | )、位非( ~ )、位异或( ^ )，除了位非( ~ )是一元操作符外，其它的都是二元操作符。
 *
 * 右移 >>: 初始值 >> 移动位数  注释：结果相当于除以2的移动位数次方
 * 左移 <<: 初始值 << 移动位数  注释：结果相当于乘以2的移动位数次方
 * 无符号右移 >>>: 初始值 >>> 移动位数  注释：
 *
 * @author wu.jinqing
 * @date 2017年06月23日
 */
public class ShiftTest {
    public static final int max = Integer.MAX_VALUE;
    public static final int min = -1;
    public static final int s = 3;

    public static void shiftMax()
    {
        int i = max;

        System.out.println("右移 >>: " + s + "位");
        System.out.println("移位前十进制数, i=" + i);
        System.out.println("移位前:" + toBinaryString(i));

        i = i >> 3;
        System.out.println("移位后十进制数, i=" + i);
        System.out.println("移位后:" + toBinaryString(i));

        int j = max;

        System.out.println("左移 <<: " + s + "位");
        System.out.println("移位前十进制数, j=" + j);
        System.out.println("移位前:" + toBinaryString(j));

        j = j << 3;

        System.out.println("移位后十进制数, j=" + j);
        System.out.println("移位后:" + toBinaryString(j));

        int k = max;

        System.out.println("无符号右移 >>>: " + s + "位");
        System.out.println("移位前十进制数, k=" + k);
        System.out.println("移位前:" + toBinaryString(k));

        k = k >>> 3;

        System.out.println("移位后十进制数, k=" + k);
        System.out.println("移位后:" + toBinaryString(k));
    }

    public static void shiftMin()
    {
        int i = min;

        System.out.println("右移 >>: " + s + "位");
        System.out.println("移位前十进制数, i=" + i);
        System.out.println("移位前:" + toBinaryString(i));

        i = i >> 3;

        System.out.println("移位后十进制数, i=" + i);
        System.out.println("移位后:" + toBinaryString(i));

        int j = min;

        System.out.println("左移 <<: " + s + "位");
        System.out.println("移位前十进制数, j=" + j);
        System.out.println("移位前:" + toBinaryString(j));

        j = j << 3;

        System.out.println("移位后十进制数, j=" + j);
        System.out.println("移位后:" + toBinaryString(j));

        int k = min;

        System.out.println("无符号右移 >>>: " + s + "位");
        System.out.println("移位前十进制数, k=" + k);
        System.out.println("移位前:" + toBinaryString(k));

        k = k >>> 3;

        System.out.println("移位后十进制数, k=" + k);
        System.out.println("移位后:" + toBinaryString(k));
    }

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
    public static void main(String[] args) {
        shiftMax();
        System.out.println("====================================");
        shiftMin();
    }
}
