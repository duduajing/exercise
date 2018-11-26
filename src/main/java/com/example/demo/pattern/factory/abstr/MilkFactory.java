package com.example.demo.pattern.factory.abstr;

import com.example.demo.pattern.factory.Mengniu;
import com.example.demo.pattern.factory.Milk;
import com.example.demo.pattern.factory.Telunsu;
import com.example.demo.pattern.factory.func.TelunsuFactory;
import com.example.demo.pattern.factory.func.YiliFactory;

public class MilkFactory extends AbstractFactory{

    @Override
    Milk getYiliMilk() {
        return new YiliFactory().getMilk();
    }

    @Override
    Milk getMengniuMilk() {
        return new Mengniu();
    }

    @Override
    Milk getTelunsuMilk() {
        return new TelunsuFactory().getMilk();
    }
}
