package com.example.demo.ParallelStudy.FuturePattern;

/**
 * FutureData是Future模式的关键， 它实际上是真实数据RealData的代理，
 * 封装了获取RealData的等待过程
 */
public class FutureData implements Data{

    protected RealData realData = null;//FutureData是RealData的包装

    protected boolean isReady = false;

    public synchronized void setRealData(RealData realData){
        if(isReady){
            return;
        }
        this.realData = realData;
        isReady = true;
        notifyAll();//  RealData已经被注入， 通知getResult()
    }

    @Override
    public synchronized String getResult() { //会等待RealData构造完成
        while(!isReady){
            try{
                wait();
            } catch (InterruptedException e){

            }
        }
        return realData.result;
    }
}
