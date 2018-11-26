package com.example.demo.pattern.factory.func;

import com.example.demo.pattern.factory.Milk;
import com.example.demo.pattern.factory.Yili;

public class YiliFactory implements Factory{
    @Override
    public Milk getMilk() {
        return new Yili();
    }
}
