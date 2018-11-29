package com.example.demo.pattern.prototype.simple;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CloneTarget extends Prototype {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
