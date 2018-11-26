package com.example.demo.Java8Study;

public class Product {

    private String name = "笔记本";

    private int num = 100;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public static void showProductName(Product product){
        System.out.println("商品名称："+product);
    }

    public int sales(int num){
        this.num -= num;
        return this.num;
    }
    @Override
    public String toString(){
      return this.name;
    }

}
