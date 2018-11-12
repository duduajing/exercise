package com.example.demo.SingletonStudy;

public class ThreadDemo extends Thread{
    @Override
    public void run(){
        long startTime  = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++){
//            Singleton.getInstance();
//            LazySingleton.getInstance();
            SerSingleton.getInstance();
        }
        System.out.println("spend: "+(System.currentTimeMillis()-startTime));
    }

    public static void main(String[] args){

            ThreadDemo d = new ThreadDemo();
            d.start();

//            d.run();

    }
}
