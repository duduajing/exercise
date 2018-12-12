package com.example.demo.pattern.proxy.jdk;

import com.example.demo.pattern.proxy.staticed.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKMeipo implements InvocationHandler {
    //被代理的对象，把引用给保存下来
    private Person target;

    /**
     * 在调用真实主题的方法前，先尝试生成真实主题对象。然后
     * 使用这个Handler生成动态代理对象。
     * @param target
     * @return
     */
    public Object getInstance(Person target){
        this.target = target;
        Class<?> clazz = target.getClass();

        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    /**
     * 该方法用于实现代理方法的内部逻辑
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("我是媒婆，我要给你找对象，现在已经拿到你的需求了");
        System.out.println("开始物色");
        method.invoke(this.target, args);
        System.out.println("如果合适，就准备办事");
        return null;
    }
}
