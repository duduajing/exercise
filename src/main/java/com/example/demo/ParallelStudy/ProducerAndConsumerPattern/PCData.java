package com.example.demo.ParallelStudy.ProducerAndConsumerPattern;

public final class PCData {

    private final int intData;

    public PCData(int intData) {
        this.intData = intData;
    }

    public PCData(String d){
        intData = Integer.valueOf(d);
    }

    public int getData() {
        return intData;
    }

    @Override
    public String toString() {
        return "PCData{" +
                "intData=" + intData +
                '}';
    }
}
