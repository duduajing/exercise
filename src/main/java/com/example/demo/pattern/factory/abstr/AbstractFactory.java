package com.example.demo.pattern.factory.abstr;

import com.example.demo.pattern.factory.Milk;

/**
 * 抽象工厂方法
 */
public abstract class AbstractFactory {
    /**
     * 生产伊利牛奶
     * @return
     */
    abstract Milk getYiliMilk();

    /**
     * 生产蒙牛牛奶
     * @return
     */
    abstract Milk getMengniuMilk();

    /**
     * 生产特仑苏
     * @return
     */
    abstract Milk getTelunsuMilk();

}
