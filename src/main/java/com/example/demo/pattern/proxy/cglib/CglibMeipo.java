package com.example.demo.pattern.proxy.cglib;

import com.example.demo.pattern.proxy.staticed.Person;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibMeipo implements MethodInterceptor {

    public Object getInstance(Class<?> clazz){
        Enhancer enhancer = new Enhancer();
        //要把哪个设置为即将生成的新类父类
        enhancer.setSuperclass(clazz);
        //指定切入器，定义代理类逻辑
        enhancer.setCallback(this);
//        enhancer.setInterfaces(new Class[]{Person.class});
        //生成代理类的实例
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("我是媒婆：我要给你找对象，现在已经拿到你的需求了");
        System.out.println("开始物色");
        methodProxy.invokeSuper(o, objects);
        System.out.println("如果合适的话，就准备办事");
        return null;
    }
}
