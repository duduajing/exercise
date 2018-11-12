package com.example.demo;

import java.util.Formatter;

public class FormatterDemo {
    public static void main(String[] args) {
        /**
         * 格式化方法是由一行格式化编码和一个以上的参数组成
         * 每行格式化编码组成为：
         * % 引入编码
         * N$ 参量数
         * N 域宽
         * L 格式化字母（d 整数； f: 浮点数；s: 常规型；等等
         * 完整描述参考java.util.Formatter的文档说明
         */

        Formatter fmtr = new Formatter();
        Object result = fmtr.format("%1$04d - the year of %2$f", 1951, Math.PI);
        System.out.println(result);
        //走捷径，给出换行分隔符
        System.out.format("%1$04d - the year of %2$f%n", 1951, Math.PI);

        System.out.printf("%1$04d - the year of %2$f%n", 1951, Math.PI);
        System.out.printf("PI is about %1$4.2f", Math.PI);

        //通过更多的控制格式化双精度数值
        System.out.printf("PI is about %1$4.2f", Math.PI);
    }
}
