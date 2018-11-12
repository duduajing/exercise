package com.example.demo.SingletonStudy;

/**
 * 可以做到延迟加载但降低了系统性能
 */
public class LazySingleton {

    private LazySingleton() {
        System.out.println("LazySingleton is create");
    }

    private static LazySingleton instance = null;

    public static synchronized LazySingleton getInstance() {
        if(instance == null){
            instance = new  LazySingleton();
        }
        return instance;
    }
    public static  void createString(){
        System.out.println("createString in LazySingleton");
    }

    public static void main(String[] args) {
//        LazySingleton.getInstance();
        LazySingleton.createString();
    }

}
