package com.example.demo.pattern.singleton.test;

import com.example.demo.pattern.singleton.lazy.LazyOne;
import com.example.demo.pattern.singleton.lazy.LazyThree;
import com.example.demo.pattern.singleton.lazy.LazyTwo;

import java.util.concurrent.CountDownLatch;

public class ThreadSafeTest {

    public static void main(String[] args) {
        int count = 200000;

        CountDownLatch latch = new CountDownLatch(count);

        long start = System.currentTimeMillis();
        for(int i = 0; i < count; i ++){
            new Thread(){
                @Override
                public void run() {

//
//                    Hungry h = Hungry.getInstance();
//                    LazyOne h = LazyOne.getInstance();
//                    LazyTwo h = LazyTwo.getInstance();

                    LazyThree h = LazyThree.getInstance();
                    System.out.println(h);
//                    try {
////                        latch.await();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
                    latch.countDown();

                }
            }.start();
//            latch.countDown();
        }

        try {
            latch.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end  = System.currentTimeMillis();
        System.out.println("总耗时： "+(end - start));
//        latch.countDown();
//        System.out.println(latch.getCount());
    }
}
