package com.example.demo.pattern.factory.abstr;

public class AbstractFactoryTest {

    public static void main(String[] args) {
        AbstractFactory factory = new MilkFactory();
        System.out.println(factory.getTelunsuMilk().getName());
    }
}
