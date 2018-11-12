package com.example.demo.ArraysStudy;

import java.io.UnsupportedEncodingException;

public class StringUtil {

    /**
     * 按照指定字节长度截取字符串，防止中文被截成一半的问题
     * @param s 源字符串
     * @param length 截取的字节数
     * @return 截取后的字符串
     * @throws UnsupportedEncodingException
     */
    public static String cutString(String s, int length) throws UnsupportedEncodingException{

        byte[] bytes = s.getBytes("Unicode");
        int n = 0; // 表示当前的字节数
        int i = 2; // 要截取的字节数，从第3个字节开始
        for (; i < bytes.length && n < length; i++){
            // 奇数位置，如3、5、7等，为UCS2编码中两个字节的第二个字节
            if (i % 2 == 1){
                n++; // 在UCS2第二个字节时n加1
            }
            else{
                // 当UCS2编码的第一个字节不等于0时，该UCS2字符为汉字，一个汉字算两个字节
                if (bytes[i] != 0){
                    n++;
                }
            }
        }
        // 如果i为奇数时，处理成偶数
        if (i % 2 == 1){
            // 该UCS2字符是汉字时，去掉这个截一半的汉字
            if (bytes[i - 1] != 0){
                i = i - 1;
            }
            // 该UCS2字符是字母或数字，则保留该字符
            else{
                i = i + 1;
            }
        }

        return new String(bytes, 0, i, "Unicode");

    }

    public static void main(String[] args) throws UnsupportedEncodingException{
        String s = "a加b等于c，如果a等1、b等于2，那么c等3";
        System.out.println(cutString(s, 6));	//测试结果为：a加b等
        System.out.println(s.substring(0, 6));	//测试结果为：a加b等于c
    }

}

