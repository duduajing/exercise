package com.example.demo.StringStudy;

import java.util.StringTokenizer;

public class StringTokenizerTest {
    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("Hello, World|of|Java",", |", true);
        while(st.hasMoreTokens()){
            System.out.println("Token: "+ st.nextToken());
        }
    }
}
