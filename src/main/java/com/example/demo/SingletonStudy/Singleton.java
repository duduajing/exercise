package com.example.demo.SingletonStudy;

/**
 * 单例类必须要有一个private访问级别的构造函数，才能确保
 * 单例不会在系统中的其他代码中被实例化。
 * instance成员变量和getInstance()方法必须是 static的
 * 缺点： 无法做到延迟加载
 */
public class Singleton {

    private Singleton() {
        System.out.println("Singleton is create");
    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance(){
        return instance;
    }

    public static  void createString(){
        System.out.println("createString in Singleton");
    }

    public static void main(String[] args) {
        Singleton.createString();
    }
}
