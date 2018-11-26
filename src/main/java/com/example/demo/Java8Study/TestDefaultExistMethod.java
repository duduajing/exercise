package com.example.demo.Java8Study;

/**
 * 验证在继承一个类的同时实现了另一个接口，而接口和该类中有相同的
 * 实现方法的时候，会以类的方法作为最优先的
 *
 */
public class TestDefaultExistMethod extends DefaultExist implements DefaultInterface, DefaultOverwriteInterface{

    public static void main(String[] args) {
        TestDefaultExistMethod testDefaultExistMethod = new TestDefaultExistMethod();
        System.out.println("继承 实现 加法结果： "+testDefaultExistMethod.add(1,2));
    }
}
