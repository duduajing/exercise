package com.example.demo.pattern.FactoryExecise;

public class ClothesFactoryTest {

    public static void main(String[] args) {
        ClothesFactory factory = new ClothesFactory();
        System.out.println(factory.getOuterWearClothes().getName());
    }
}
