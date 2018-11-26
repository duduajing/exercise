package com.example.demo.pattern.FactoryExecise.func;

import com.example.demo.pattern.FactoryExecise.Clothes;
import com.example.demo.pattern.FactoryExecise.Pants;

public class PantsFactory implements Factory{
    @Override
    public Clothes getClothes() {
        return new Pants();
    }
}
