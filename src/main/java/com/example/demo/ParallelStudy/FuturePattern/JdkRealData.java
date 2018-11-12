package com.example.demo.ParallelStudy.FuturePattern;

import java.util.concurrent.*;

/**
 * 在JDK的并发包中，已经内置了一种Future模式的实现。
 * future模式的核心在于去除了主函数中的等待时间，并使得原本需要
 * 等待的时间段可以处理其他业务逻辑，从而充分利用计算机资源
 */
public class JdkRealData implements Callable<String> {

    private String para;

    public JdkRealData(String para) {
        this.para = para;
    }

    @Override
    public String call() throws Exception {

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < 10; i++){
            sb.append(para);
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){

            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //构造FutureTask
        FutureTask<String> future = new FutureTask<String>(new JdkRealData("a"));
        ExecutorService executor = Executors.newFixedThreadPool(1);
        //执行FutureTask, 相当于上例中的client.request("a")发送请求
        //在这里开启线程进行RealData的call()执行
        executor.submit(future);
        System.out.println("请求完毕");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据= "+future.get());

    }
}