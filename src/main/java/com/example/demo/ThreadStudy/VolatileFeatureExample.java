package com.example.demo.ThreadStudy;

public class VolatileFeatureExample {

    volatile long v1 = 0L;

    public void set(long l){
        v1 = l;
    }

    public void getAndIncrement(){
        v1++;
    }

    public long get(){
        return v1;
    }
}
