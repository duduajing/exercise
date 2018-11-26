package com.example.demo.pattern.factory.func;

public class FactoryTest {
    public static void main(String[] args) {
        Factory factory = new YiliFactory();
        System.out.println(factory.getMilk());
    }
}
