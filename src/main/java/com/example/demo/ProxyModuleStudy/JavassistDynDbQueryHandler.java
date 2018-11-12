package com.example.demo.ProxyModuleStudy;

import javassist.*;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

import java.lang.reflect.Method;

public class JavassistDynDbQueryHandler implements MethodHandler {
    IDBQuery real = null;
    @Override
    public Object invoke(Object o, Method method, Method method1, Object[] objects) throws Throwable {
        if(real == null){
           real = new DBQuery();
        }
        return real.request();
    }

    public static IDBQuery createJavassistDynProxy() throws Exception {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setInterfaces(new Class[]{
                IDBQuery.class
        });

        Class proxyClass = proxyFactory.createClass();
        IDBQuery javassistProxy = (IDBQuery)proxyClass.newInstance();
        ((ProxyObject)javassistProxy).setHandler(new JavassistDynDbQueryHandler());

        return javassistProxy;
    }

    public static IDBQuery createJavassitBytecodeDynamicProxy() throws Exception{
        ClassPool mPool = new ClassPool(true);
        //定义类名
        CtClass mCtc = mPool.makeClass(IDBQuery.class.getName()+"JavaassitBytecodeProxy");
        //需要实现的接口
        mCtc.addInterface(mPool.get(IDBQuery.class.getName()));
        //添加构造函数
        mCtc.addConstructor(CtNewConstructor.defaultConstructor(mCtc));
        // 添加类的字段信息，使用动态java代码
        mCtc.addField(CtField.make("public "+IDBQuery.class.getName() +" real;",mCtc));
        String dbqueryname = DBQuery.class.getName();
        //添加方法，这里使用动态java代码制定内部逻辑
        mCtc.addMethod(CtNewMethod.make("public String request(){ if(real == null) real=new "
        +dbqueryname+"(); return real.request();}", mCtc));
        //基于以上信息，生成动态类
        Class pc = mCtc.toClass();
        //生成动态类的实例
        IDBQuery bytecodeProxy = (IDBQuery) pc.newInstance();
        return bytecodeProxy;
    }
}
