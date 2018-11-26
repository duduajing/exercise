package com.example.demo.pattern.factory.func;

import com.example.demo.pattern.factory.Milk;

/**
 * 工厂模型
 */
public interface Factory {
    //  生产产品的统一接口
    Milk getMilk();
}
