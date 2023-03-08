package com.sunrui;

public class demo2 {
    public static void main(String[] args) {
        //整数拓展，进制表示，二进制0b，八进制0，十六进制0X
        int i = 10;
        int i1 = 0b10;
        int i2 = 010;
        int i3 = 0X10;
        System.out.println("十进制："+i);
        System.out.println("二进制："+i1);
        System.out.println("八进制："+i2);
        System.out.println("十六进制："+i3);

        //浮点数拓展：银行业务
        float f = 0.1f;
        double d = 1.0/10d;
    }
}
