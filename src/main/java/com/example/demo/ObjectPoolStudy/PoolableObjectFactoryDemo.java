package com.example.demo.ObjectPoolStudy;

import java.util.concurrent.atomic.AtomicInteger;

public class PoolableObjectFactoryDemo implements  org.apache.commons.pool.PoolableObjectFactory{
    private static AtomicInteger counter = new AtomicInteger();

    /**
     * 创建对象
     * @return
     */
    @Override
    public Object makeObject() {
        Object obj = String.valueOf(counter.getAndIncrement());
        System.out.println("Create Object " + obj);
        return obj;
    }

    /**
     * 在取出前调用
     * @param obj
     */
    @Override
    public void activateObject(Object obj) {
        System.out.println("Before borrow "+ obj);
    }

    @Override
    public void passivateObject(Object obj) {
        System.out.println("return "+obj);
    }

    @Override
    public boolean validateObject(Object obj) {
        return true;
    }

    @Override
    public void destroyObject(Object obj) {
        System.out.println("Destorying Object "+ obj);
    }
}
