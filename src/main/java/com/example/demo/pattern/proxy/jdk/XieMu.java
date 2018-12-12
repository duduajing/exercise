package com.example.demo.pattern.proxy.jdk;

import com.example.demo.pattern.proxy.staticed.Person;

public class XieMu implements Person {
    @Override
    public void findLover() {
        System.out.println("又高又帅");
        System.out.println("还多金");
    }

    @Override
    public void findHouse() {
        System.out.println("租房子");
    }

    @Override
    public void buy() {
        System.out.println("代购");
    }

    @Override
    public void findJob() {
        System.out.println("找个工资高的工作");
    }
}
