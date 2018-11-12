package com.example.demo.ParallelStudy.GuradedSuspensionPattern;

import com.example.demo.ParallelStudy.FuturePattern.Data;

public class Request {

    private String name;

    private Data response;

    public Request(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public synchronized Data getResponse() {
        return response;
    }

    public synchronized void setResponse(Data response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                '}';
    }
}
