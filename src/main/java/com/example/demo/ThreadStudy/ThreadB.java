package com.example.demo.ThreadStudy;

public class ThreadB implements Runnable{

    public static void main(String[] args) {
        ThreadB task = new ThreadB();
        Thread thread = new Thread(task);
//        thread.setUncaughtExceptionHandler(new ExceptionHandlerThreadB());
        thread.start();
    }
    @Override
    public void run() {
        int number0 = Integer.parseInt("TTT");
    }
}
