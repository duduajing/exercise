package com.example.demo.ParallelStudy;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CreateThreadTest {
    public static void main(String[] args) {
//        ThreadA threada = new ThreadA();
//        threada.start();
//        System.out.println("这是主线程：");

       /* ThreadB threadB = new ThreadB();
        new Thread(threadB).start();
//        threadB.run();
        System.out.println("这是主线程：");*/

        Threadc threadC = new Threadc();
        FutureTask<String> futureTask = new FutureTask<String>(threadC);
        new Thread(futureTask).start();
        System.out.println("这是主线程；begin");
        try {
            System.out.println(" 得到的返回结果是： " + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(" 这是主线程： end");

    }
}

    /**
     * extend 一个父类
     */
    class ThreadA extends Thread {

        @Override
        public void run() {
            super.run();
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("这是线程A");
        }
    }

    /**
     * 第二种实现方式是实现Runnable接口，实现run()方法。
     */
    class ThreadB implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("这是线程B");
        }
    }

/**
 * implements Callable，实现call()方法可以得到线程的执行结果。
 */
class Threadc implements Callable<String> {

        @Override
        public String call() throws Exception {

            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("这是线程C");
            return "Thread c";
        }
    }

