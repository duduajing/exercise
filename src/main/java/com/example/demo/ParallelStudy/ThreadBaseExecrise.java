package com.example.demo.ParallelStudy;

public class ThreadBaseExecrise {
    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        for(int i = 0; i < 5; i++){
            new Thread(threadTest, "线程名称:（"+i+" )").start();
        }

        //返回对当前正在执行的线程对象的引用。此处获得我们的主线程
        Thread threadMain  = Thread.currentThread();
        String curThreadName = threadMain.getName();
        System.out.println("这是主线程： ");
        System.out.println("返回当前线程 "+curThreadName+"的线程中活动线程的数目： "+Thread.activeCount());
        System.out.println("返回该线程的标识符： "+threadMain.getId());
        System.out.println("返回线程"+curThreadName+"的优先级"+threadMain.getPriority());
        System.out.println("返回线程"+curThreadName+"的优先级"+threadMain.getState());
        System.out.println("返回线程"+curThreadName+"所属的线程组"+threadMain.getThreadGroup());
        System.out.println("测试线程"+curThreadName+"是否处于活跃状态"+threadMain.isAlive());
        System.out.println("测试线程"+curThreadName+"是否是守护线程"+threadMain.isDaemon());
        System.out.println("返回线程"+curThreadName+"  "+threadMain.getStackTrace());
    }

}

 class ThreadTest implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(100000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread curThread = Thread.currentThread();
        String curThreadName = curThread.getName();
        System.out.println("这是线程的名称： "+curThread.getName());
        System.out.println("返回当前线程 "+curThreadName+"的线程中活动线程的数目： "+Thread.activeCount());
        System.out.println("返回该线程的标识符： "+curThread.getId());
        System.out.println("返回线程"+curThreadName+"的优先级"+curThread.getPriority());
        System.out.println("返回线程"+curThreadName+"的优先级"+curThread.getState());
        System.out.println("返回线程"+curThreadName+"所属的线程组"+curThread.getThreadGroup());
        System.out.println("测试线程"+curThreadName+"是否处于活跃状态"+curThread.isAlive());
        System.out.println("测试线程"+curThreadName+"是否是守护线程"+curThread.isDaemon());
        System.out.println("返回线程"+curThreadName+"  "+curThread.getStackTrace());


    }
}