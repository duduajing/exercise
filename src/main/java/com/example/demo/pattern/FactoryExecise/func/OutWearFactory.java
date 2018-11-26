package com.example.demo.pattern.FactoryExecise.func;

import com.example.demo.pattern.FactoryExecise.Clothes;
import com.example.demo.pattern.FactoryExecise.OuterWear;

public class OutWearFactory implements Factory{
    @Override
    public Clothes getClothes() {
        return new OuterWear();
    }
}
