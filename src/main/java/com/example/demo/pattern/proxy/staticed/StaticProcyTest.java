package com.example.demo.pattern.proxy.staticed;

public class StaticProcyTest {

    public static void main(String[] args) {
        Son son = new Son();
        //只能帮儿子找对象，不能帮其他人找
        new Father(son).findLover();
    }
}
