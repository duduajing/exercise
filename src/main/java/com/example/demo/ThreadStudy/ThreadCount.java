package com.example.demo.ThreadStudy;

public class ThreadCount extends Thread{

    public static void main(String[] args) {
        Count count = new Count();
        for(int i = 0; i < 5; i++){
            ThreadCount task = new ThreadCount(count);
            task.start();
        }

        try {
            Thread.sleep(1001);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("5个人干完活最后的值是： "+count.num);
    }

    private Count count;

    public ThreadCount(Count count) {
        this.count = count;
    }

    @Override
    public void run(){
        count.add();
    }
}
