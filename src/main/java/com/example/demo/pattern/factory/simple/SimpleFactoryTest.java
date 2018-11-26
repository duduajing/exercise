package com.example.demo.pattern.factory.simple;

import com.example.demo.pattern.factory.simple.SimpleFactory;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        System.out.println(SimpleFactory.getMilk("mengniu").getName());
    }
}
