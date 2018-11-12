package com.example.demo.ParallelStudy.GuradedSuspensionPattern;


import lombok.Synchronized;

import java.util.LinkedList;

public class RequestQueue {

    private LinkedList queue = new LinkedList();

    public synchronized Request getRequest(){
        while(queue.size() == 0){
            try {
                //等待直到有新的request加入
                wait();
            } catch (InterruptedException e) {
            }
        }
        //返回request队列的第一个
        return (Request)queue.remove();
    }

    public synchronized void addRequest(Request request){
        queue.add(request);
        notifyAll();//通知getRequest()方法
    }

}
