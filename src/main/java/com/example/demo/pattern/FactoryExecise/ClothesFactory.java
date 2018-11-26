package com.example.demo.pattern.FactoryExecise;

import com.example.demo.pattern.FactoryExecise.func.OutWearFactory;
import com.example.demo.pattern.FactoryExecise.func.PantsFactory;

public class ClothesFactory extends AbstractClothesFactory{

    @Override
    Clothes getOuterWearClothes() {
        return new OutWearFactory().getClothes();
    }

    @Override
    Clothes getPantsClothes() {
        return new PantsFactory().getClothes();
    }
}
