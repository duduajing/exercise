package com.example.demo;

public class EfficacyOptimizeTest {
    public static void main(String[] args) {
        openLoopNo();
        openLoopYes();
    }

    public static void openLoopNo(){
        long start = System.currentTimeMillis();
        int[] array = new int[99999999];
        for(Integer i = 0; i < 99999999; i++){
            array[i] = i;
        }
        System.out.println(System.currentTimeMillis()-start);
    }
    public static void openLoopYes(){
        long start = System.currentTimeMillis();
        int[] array = new int[99999999];
        for(Integer i = 0; i < 99999999; i+=3){
            array[i] = i;
            array[i+1] = i+1;
            array[i+2] = i+2;
        }
        System.out.println(System.currentTimeMillis()-start);
    }

}
