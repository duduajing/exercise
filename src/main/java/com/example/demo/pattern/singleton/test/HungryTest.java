package com.example.demo.pattern.singleton.test;

import com.example.demo.pattern.singleton.hungry.Hungry;

public class HungryTest {

    public static void main(String[] args) {
       Hungry h =  Hungry.getInstance();
       System.out.println(h);


    }
}
