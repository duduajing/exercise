package com.example.demo.pattern.proxy.custom;

import com.example.demo.pattern.proxy.staticed.Person;

import java.lang.reflect.Method;

public class CustomMeipo implements GPInvocationHandler{
    //被代理的对象，把引用给保存下来
    private Person target;

    public Object getInstance(Person target){
        this.target = target;
        Class<?> clazz = target.getClass();

        return GPProxy.newProxyInstance(new GPClassLoader(),clazz.getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是媒婆，我要给你找对象，现在已经拿到你的需求了");
        System.out.println("开始物色");
        method.invoke(this.target, args);
        System.out.println("如果合适，就准备办事");
        return null;
    }
}
