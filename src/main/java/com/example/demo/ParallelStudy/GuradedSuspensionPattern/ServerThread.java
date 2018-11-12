package com.example.demo.ParallelStudy.GuradedSuspensionPattern;

import com.example.demo.ParallelStudy.FuturePattern.FutureData;
import com.example.demo.ParallelStudy.FuturePattern.RealData;

public class ServerThread extends Thread{
    private RequestQueue requestQueue;

    public ServerThread(String name, RequestQueue requestQueue) {
        super(name);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        while (true){
            final Request request = requestQueue.getRequest();
            final FutureData futureData = (FutureData)request.getResponse();
            // RealData的创建比较耗时
            RealData realData = new RealData(request.getName());
            //处理完成后，通知客户进程
            futureData.setRealData(realData);
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName()+" handles "+request);
        }
    }
}
