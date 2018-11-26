package com.example.demo.Java8Study;

import java.util.HashMap;
import java.util.Map;

public class TestMapModule {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        for(int i =0; i < 10; i++){
            map.putIfAbsent(i, "val"+i);
        }
        map.forEach((id, val)->System.out.println(val));
    }
}
