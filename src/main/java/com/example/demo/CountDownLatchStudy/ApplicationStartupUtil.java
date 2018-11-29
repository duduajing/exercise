package com.example.demo.CountDownLatchStudy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApplicationStartupUtil {

    private static List<BaseHealthChecker> _services;

    private static CountDownLatch _latch;

    public ApplicationStartupUtil() {
    }

    private final static ApplicationStartupUtil INSTANCE = new ApplicationStartupUtil();

    public static ApplicationStartupUtil getInstance(){
        return INSTANCE;
    }

    public static boolean checkExternalServices() throws Exception{
        Boolean result = true;
        // 初始化
        _latch = new CountDownLatch(3);

        _services = new ArrayList<BaseHealthChecker>();
        _services.add(new NetworkHealthChecker(_latch));
        _services.add(new CacheHealthChecker(_latch));
        _services.add(new DatabaseHealthChecker(_latch));

        Executor executor = Executors.newFixedThreadPool(_services.size());
//        int serSize = _services.size();
//        for(int i = 0; i < serSize; i++){
////            executor.execute(_services.get(i));
//        }
        for(final BaseHealthChecker v : _services){
            executor.execute(v);

        }
        //Now wait till all services are checked
        _latch.await();

        //Services are file and now proceed startup
        for(final BaseHealthChecker v : _services){
           if(!v.isServiceUp()){
               result =  false;
           }
        }
        if(result){
           ((ExecutorService) executor).shutdown();
        }

        return result;
    }

    public static void main(String[] args) {
        boolean result = false;
        try {
            result = ApplicationStartupUtil.checkExternalServices();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("External services validation completed!! Result was ::" +result );
    }
}
