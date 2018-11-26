package com.example.demo.pattern.factory.func;

import com.example.demo.pattern.factory.Milk;
import com.example.demo.pattern.factory.Telunsu;

public class TelunsuFactory implements Factory{
    @Override
    public Milk getMilk() {
        return new Telunsu();
    }
}
