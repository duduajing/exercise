package com.example.demo.pattern.prototype.simple;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Prototype implements Cloneable{

    private String name;

    private CloneTarget target;

    private List<CloneTarget> list;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
