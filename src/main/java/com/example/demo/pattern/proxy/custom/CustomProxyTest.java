package com.example.demo.pattern.proxy.custom;

import com.example.demo.pattern.proxy.jdk.XieMu;
import com.example.demo.pattern.proxy.staticed.Person;

public class CustomProxyTest {

    public static void main(String[] args) {
        try {
            Person obj = (Person)new CustomMeipo().getInstance(new XieMu());
//            System.out.println(obj.getClass());
            obj.findLover();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
