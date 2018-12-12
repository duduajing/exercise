package com.example.demo.pattern.proxy.custom;

import org.springframework.cglib.proxy.MethodInterceptor;

import java.lang.reflect.Method;

public interface GPInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
