package com.example.demo.ParallelStudy.GuradedSuspensionPattern;

/**
 *  Guarded Suspension意为保护暂停，其核心思想是仅当服务进程准备好时，才提供服务。
 *  例如以下的场景，服务器可能会在很短时间内承受大量的客户端请求，客户端请求的数量可能
 *  超过服务器本身的及时处理能力，而服务端程序又不能丢弃任何一个客户请求。此时，最佳的
 *  处理方案莫过于让客户端请求进行排队，由服务端程序一个接一个处理。这样，既保证了所有
 *  客户端的请求均不丢失，同时也避免服务器由于处理太多请求而崩溃。
 *
 */
public class TestGuradedSuspen {

    public static void main(String[] args) {

        RequestQueue requestQueue = new RequestQueue();
        for(int i = 0; i < 10; i++){
           new ServerThread("ServerThread"+i, requestQueue)
                   .start();
        }
        for(int i = 0; i < 10; i++){
            new ClientThread("ClientThread"+i, requestQueue)
                    .start();
        }

    }
}
