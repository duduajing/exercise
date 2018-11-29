package com.example.demo.pattern.singleton.test;

import com.example.demo.pattern.singleton.register.BeanFactory;

import java.util.concurrent.CountDownLatch;

public class BeanFactoryTest {

    public static void main(String[] args) {
        int count = 200;

        CountDownLatch latch = new CountDownLatch(count);
        long start = System.currentTimeMillis();
        for(int i = 0; i < count; i ++){
            new Thread(){
                @Override
                public void run() {

                    Object obj = BeanFactory.getBean("com.example.demo.pattern.singleton.register.Pojo");
                    System.out.println(System.currentTimeMillis()+":"+obj);
                    latch.countDown();
                }
            }.start();



        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时： "+(end -start));
    }
}
