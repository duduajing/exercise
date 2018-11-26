package com.example.demo.Java8Study;

public interface DefaultOverwriteInterface extends DefaultInterface{
    /**
     * 默认多加100来区分DefaultInterface的add
     * @param a
     * @param b
     * @return
     */
    @Override
    default  int add(int a, int b){
        return a + b + 100;
    }
}
