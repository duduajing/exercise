package com.example.demo.Java8Study;

/**
 * java8中 可以使用default关键字，为接口添加非抽象的方法实现。在实现拥有default方法
 * 的接口时，可以直接使用该默认方法。
 * 测试java8接口新特性（默认方法/扩展方法）
 */
public interface DefaultInterface {
    /**
     * 加法
     * @param a
     * @param b
     * @return
     */
    default int add(int a, int b){
        return a+b;
    }
}
