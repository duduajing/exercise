package com.example.demo.ParallelStudy.FuturePattern;

/**
 * RealData是最终需要使用的数据模型，它的构造很慢。在这里使用sleep()
 * 函数模拟整个过程
 */
public class RealData implements Data{
    protected final String result;

    public RealData(String para) {

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++){
            sb.append(para);
        }
        try{
            Thread.sleep(100);
        } catch (InterruptedException e) {

        }
        this.result = sb.toString();
    }

    @Override
    public String getResult() {
        return result;
    }
}
