package com.example.demo.ThreadStudy;

import java.util.concurrent.atomic.AtomicInteger;

public class Count {

    public AtomicInteger num = new AtomicInteger();
//    public int num = 0;
    public synchronized  void add(){
        try {
            Thread.sleep(51);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num.getAndIncrement();
//        num ++;
        System.out.println(Thread.currentThread().getName()+"-"+num);
    }
}
