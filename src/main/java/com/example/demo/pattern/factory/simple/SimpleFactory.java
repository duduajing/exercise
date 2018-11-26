package com.example.demo.pattern.factory.simple;

import com.example.demo.pattern.factory.Mengniu;
import com.example.demo.pattern.factory.Milk;
import com.example.demo.pattern.factory.Telunsu;
import com.example.demo.pattern.factory.Yili;

public class SimpleFactory {

    public static Milk getMilk(String name){
        if("telunsu".equals(name)){
            return new Telunsu();
        }
        if("yili".equals(name)){
            return  new Yili();
        }
        if("mengniu".equals(name)){
            return new Mengniu();
        }
        return null;
    }
}
