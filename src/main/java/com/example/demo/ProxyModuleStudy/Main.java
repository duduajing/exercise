package com.example.demo.ProxyModuleStudy;

import static com.example.demo.ProxyModuleStudy.CglibDbQueryInterceptor.createCglibProxy;
import static com.example.demo.ProxyModuleStudy.JavassistDynDbQueryHandler.createJavassitBytecodeDynamicProxy;
import static com.example.demo.ProxyModuleStudy.JdkDbQueryHandler.createJdkProxy;

public class Main {
    public static final int CIRCLE = 30000000;

    public static void main(String[] args) throws Exception {
        //JDK动态代理
        IDBQuery d = null;
        long begin = System.currentTimeMillis();
        d = createJdkProxy();
        System.out.println("createJdkProxy:" + (System.currentTimeMillis() - begin));
        begin = System.currentTimeMillis();
        for (int i = 0; i < CIRCLE; i++) {
            d.request();
        }
        System.out.println("callJdkProxy:" + (System.currentTimeMillis() - begin));
        //cglib动态代理
        begin = System.currentTimeMillis();
        d = createCglibProxy();
        System.out.println("createCglibProxy:" + (System.currentTimeMillis() - begin));
        System.out.println("CglibProxy class:" + d.getClass().getName());
        begin = System.currentTimeMillis();
        for (int i = 0; i < CIRCLE; i++) {
            d.request();
        }
        System.out.println("callCglibProxy:" + (System.currentTimeMillis() - begin));

        //javaassist动态代理
        begin = System.currentTimeMillis();
        d = createJavassitBytecodeDynamicProxy();
        System.out.println("createJavassistBytecodeDynamicProxy:"+(System.currentTimeMillis()-begin));
        System.out.println("JavassitBytecodeDynamicProxy class:"+d.getClass().getName());
        begin = System.currentTimeMillis();
        for (int i = 0; i < CIRCLE; i++) {
            d.request();
        }
        System.out.println("callJavassitBytecodeDynamicProxy:" + (System.currentTimeMillis() - begin));


    }
}
