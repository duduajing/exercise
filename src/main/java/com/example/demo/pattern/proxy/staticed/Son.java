package com.example.demo.pattern.proxy.staticed;
/**
 *
 * 被代理的目标类
 * @author dcj
 * @date 2018/12/5 11:40 AM
 * @param
 * @return
 */
public class Son implements Person{
    @Override
    public void findLover() {
        System.out.println("找个高富帅");
    }

    @Override
    public void findHouse() {

    }

    @Override
    public void buy() {

    }

    @Override
    public void findJob() {

    }
}
