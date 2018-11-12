package com.example.demo.SingletonStudy;

/**
 * 使用内部类来维护单例的实例
 * 但特殊情况下仍然可能导致系统生成多个实例。例如利用反射
 * 或者序列化和反序化可能会破坏单例
 */
public class StaticSingleton {
    private StaticSingleton(){
        System.out.println("StaticSingleton is create");
    }

    private static class SingletonHolder{
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance(){
        return SingletonHolder.instance;
    }
}
