package com.example.demo.Java8Study;

public class TestFuncInterfaceMethod {

    public static void main(String[] args) {
        FuncInterface fun = System.out::println;
        fun.test("测试成功");
    }
}
