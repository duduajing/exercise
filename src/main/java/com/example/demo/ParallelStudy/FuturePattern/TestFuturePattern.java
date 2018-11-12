package com.example.demo.ParallelStudy.FuturePattern;

/**
 * 测试future模式
 */
public class TestFuturePattern {
    public static void main(String[] args) {
        Client client = new Client();
        Data data = client.request("name");
        System.out.println("请求完毕");
        try{
            //在这里可以用一个sleep 代替对其他业务逻辑的处理
            // 在处理这些业务逻辑的过程中， RealData被创建， 从而充分利用等待时间
            Thread.sleep(2000);
        } catch (InterruptedException e){

        }

        System.out.println("数据= "+data.getResult());
    }
}
