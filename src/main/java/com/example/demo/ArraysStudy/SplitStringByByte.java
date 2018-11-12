package com.example.demo.ArraysStudy;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class SplitStringByByte {

    public static void main(String[] args) {
        System.out.println("sss".getBytes());
        try {
            System.out.println("ab你好".getBytes("GBK").length);
            System.out.println("ab123".getBytes("UTF8").length);
            System.out.println("ab123".length());
            System.out.println("ab你好".length());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }



    }
}
