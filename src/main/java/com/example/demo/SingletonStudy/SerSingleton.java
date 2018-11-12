package com.example.demo.SingletonStudy;

/**
 * @author dcj
 */
public class SerSingleton implements java.io.Serializable {


    String name;

    private SerSingleton(){
        System.out.println("Singleton is create");
        name="SerSingleton";
    }

    private static SerSingleton instance = new SerSingleton();
    public static SerSingleton getInstance(){
        return instance;
    }

    public static  void createString(){
        System.out.println("createString in singleton");
    }

    /**
     * 阻止生成新的实例，总是返回当前对象
     * @return
     */
//    private Object readResolve(){
//        return instance;
//    }
}
