package com.example.demo.Java8Study;

/**
 * 它遵从了优先选取最具体的实现原则
 */
public class TestDefaultOverwriteMethod implements DefaultInterface, DefaultOverwriteInterface{
    public static void main(String[] args) {
        TestDefaultOverwriteMethod testDefaultOverwriteMethod = new TestDefaultOverwriteMethod();
        System.out.println(" 重写加法结果： "+testDefaultOverwriteMethod.add(1, 2));
    }
}
