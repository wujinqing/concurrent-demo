package com.jin.concurrent.test1;

/**
 * 右移 >>: 初始值 >> 移动位数  注释：结果相当于除以2的移动位数次方
 * 左移 <<: 初始值 << 移动位数  注释：结果相当于乘以2的移动位数次方
 * 无符号右移 >>>: 初始值 >>> 移动位数  注释：
 *
 * @author wu.jinqing
 * @date 2017年06月23日
 */
public class ShiftTest {
    public static final int v = Integer.MIN_VALUE;
    public static final int s = 3;
    public static void main(String[] args) {
        int i = v;
        System.out.println("原始十进制数, v=" + v);

        System.out.println("十进制, i=" + i + "; 二进制:" + Integer.toBinaryString(i));
        i = i >> 3;
        System.out.println("右移 >>" + s + "位, 二进制:" + Integer.toBinaryString(i));
        System.out.println("十进制, i=" + i + "; 二进制, i=" + Integer.toBinaryString(i));

        int j = v;
        System.out.println("左移 <<");
        System.out.println("十进制, j=" + j + "; 二进制, j=" + Integer.toBinaryString(j));
        j = j << 3;
        System.out.println("十进制, j=" + j + "; 二进制, j=" + Integer.toBinaryString(j));

        int k = v;
        System.out.println("无符号右移 >>>");
        System.out.println("十进制, k=" + k + "; 二进制, k=" + Integer.toBinaryString(k));
        k = k >>> 3;
        System.out.println("十进制, k=" + k + "; 二进制, k=" + Integer.toBinaryString(k));
    }
}
