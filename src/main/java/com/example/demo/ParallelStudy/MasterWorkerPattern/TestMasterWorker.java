package com.example.demo.ParallelStudy.MasterWorkerPattern;

import java.util.Map;
import java.util.Set;

/**
 * Master-Worker模式是常用的并行模式之一。
 * 它的核心思想是，系统由两类进程写作工作：Master进程和Worker进程。
 * Master进程负责接收和分配任务，Worker进程负责处理子任务。
 * 当各个Worker进程将子任务处理完成后，将结果返回给Master进程，
 * 由Master  进程做归纳和汇总。从而得到系统的最终结果。
 *
 */
public class TestMasterWorker {

    public static void main(String[] args) {
        Master m=new Master(new PlusWorker(), 5);
        for(int i = 0; i < 100; i++){
            m.submit(i);
        }
        m.execute();

        int re = 0;
        Map<String, Object> resutMap = m.getResultMap();
        while(resutMap.size() > 0 || !m.isComplete()){
            Set<String> keys = resutMap.keySet();
            String key = null;
            for(String k:keys){
                key = k;
                break;
            }
            Integer i = null;
            if(key != null){
                i = (Integer) resutMap.get(key);
            }
            if(i != null){
              re+=i;
            }
            if(key != null){
                //移除已经被计算过的项
                resutMap.remove(key);
            }

        }
        System.out.println(re);
    }
}
