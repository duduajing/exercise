package com.example.demo.ParallelStudy.GuradedSuspensionPattern;

import com.example.demo.ParallelStudy.FuturePattern.FutureData;

import java.util.ArrayList;
import java.util.List;

public class ClientThread extends Thread{

    private RequestQueue requestQueue;

    private List<Request> myRequest = new ArrayList<Request>();

    public ClientThread(String name, RequestQueue requestQueue) {
        super(name);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Request request = new Request("RequestId: "+ i+
                    " Thread_Name:"+Thread.currentThread().getName());

            System.out.println(Thread.currentThread().getName() + " requests "+request);
            //设置一个FutureData的返回值
            request.setResponse(new FutureData());

            requestQueue.addRequest(request);
            //发送请求
            myRequest.add(request);
            try {
                //客户端请求的速度快于服务端处理的速度
                Thread.sleep(10);
            } catch (InterruptedException e) {

            }
        }

        for(Request r:myRequest){
            System.out.println("ClientThread name is: "+
            Thread.currentThread().getName()+
            "Response is:"+
                    //如果服务器还没有处理完， 这里会等待
            r.getResponse().getResult());
        }
    }
}
