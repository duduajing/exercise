package com.example.demo.ProxyModuleStudy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDbQueryInterceptor implements MethodInterceptor {

    IDBQuery real = null;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if(real == null){
            real = new DBQueryProxy();
        }
        return real.request();
    }

    public static IDBQuery createCglibProxy(){
        Enhancer enhancer = new Enhancer();
        //指定切入器，定义代理类逻辑
        enhancer.setCallback(new CglibDbQueryInterceptor());
        //指定实现的接口
        enhancer.setInterfaces(new Class[]{IDBQuery.class});
        //生成代理类的实例
        IDBQuery cglibProxy = (IDBQuery) enhancer.create();

        return cglibProxy;
    }
}
