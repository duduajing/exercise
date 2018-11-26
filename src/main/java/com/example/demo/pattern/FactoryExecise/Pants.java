package com.example.demo.pattern.FactoryExecise;

/**
 * 裤子
 */
public class Pants extends Clothes{

    @Override
    public String getName(){
        return "牛仔裤";
    }

    @Override
    public String getMaterial(){
        return "牛仔布";
    }

}
