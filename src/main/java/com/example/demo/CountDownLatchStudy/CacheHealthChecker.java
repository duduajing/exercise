package com.example.demo.CountDownLatchStudy;

import java.util.concurrent.CountDownLatch;

public class CacheHealthChecker extends BaseHealthChecker{
    public CacheHealthChecker(CountDownLatch latch) {
        super("Cache Service", latch);
    }

    @Override
    public void verifyService() {
        System.out.println("Checking " + this.getSeriveName());

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getSeriveName() + "is UP");
    }
}
