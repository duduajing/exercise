package com.example.demo.ParallelStudy.ThreadPoolStudy;

/**
 * 比较使用线程池和单独去创建多个线程的效率的比较.
 * 线程池可以减少线程频繁调度的开销。
 */
public class CompareThreadPoolAndSingle {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//         singleThreadCreate();
        userThreadPool();
        System.out.println("创建线程所需时间 "+(start-System.currentTimeMillis()));
    }
    /**
     *  频繁的创建单个线程
     */
    public static void singleThreadCreate(){

        for(int i=0; i < 10000; i++){
            new Thread(new MyThread("testNoThreadPool"+Integer.toString(i))).start();
        }

    }

    /**
     * 使用线程池创建线程
     */
    public static void userThreadPool(){
        for(int i=0; i < 10000; i++){
           ThreadPool.getInstance().start(new MyThread("testThreadPool"+Integer.toString(i)));
        }
    }
}
