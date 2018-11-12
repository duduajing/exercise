package com.example.demo.ObjectPoolStudy;


import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.PoolableObjectFactory;
import org.apache.commons.pool.impl.GenericObjectPool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 在该类中可以看到，在3个线程向对象池，一共建立了3个对象。这3个对象
 * 被不停地复用，当对象被关闭时，使用了对象池工厂的destoryObject()
 * 方法，销毁对象，释放资源。
 */
public class ObjectPoolDemo {
    static PoolableObjectFactory factory = new PoolableObjectFactoryDemo();
    static ObjectPool pool = new GenericObjectPool(factory);
    private static AtomicInteger endcount = new AtomicInteger(0);

    public static class PoolThread extends Thread{
        @Override
        public void run() {
            Object obj = null;
            try{
                for (int i = 0; i < 100; i++){
                    System.out.println("== "+ i + "==");
                    //从池中得到对象
                    obj = pool.borrowObject();
                    // 模拟使用对象
                    System.out.println(obj+" is get");
                    //使用完成后， 将对象返回池中
                    pool.returnObject(obj);


                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                endcount.getAndIncrement();
            }

        }
    }

    public static void main(String[] args) {
        new PoolThread().start();
        new PoolThread().start();
        new PoolThread().start();
        try{
            while (true){
                if(endcount.get() == 3){ //等待3个线程全部结束
                    pool.close();
                    break;
                }
            }
        } catch (Exception e){

        }
    }
}
