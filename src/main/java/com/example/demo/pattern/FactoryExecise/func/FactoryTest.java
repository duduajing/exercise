package com.example.demo.pattern.FactoryExecise.func;

public class FactoryTest {

    public static void main(String[] args) {
        Factory f = new OutWearFactory();
        System.out.println(f.getClothes());
    }
}
