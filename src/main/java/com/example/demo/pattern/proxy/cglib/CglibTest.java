package com.example.demo.pattern.proxy.cglib;

public class CglibTest {

    public static void main(String[] args) {
        try {
            ZhangSan obj = (ZhangSan) new CglibMeipo().getInstance(ZhangSan.class);
            obj.findLove();
            System.out.println("_----");
            System.out.println(obj.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
