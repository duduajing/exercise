package com.example.demo.CountDownLatchStudy;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    private static CountDownLatch countDownLatch = new CountDownLatch(3);

    static class BossThread extends Thread{
        @Override
        public void run() {
            System.out.println("Boss在会议室等待， 总共有"+countDownLatch.getCount()+"个人开会");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("所有人都到齐了，开会吧");

        }
    }

    static class EmployeeThread extends Thread{
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName()+", 到达会议室.....");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }

        }
    }

    public static void main(String[] args) {
        new BossThread().start();

        long size = countDownLatch.getCount();
        for(long i = 0; i < size; i++){
            new EmployeeThread().start();
        }

    }
}
