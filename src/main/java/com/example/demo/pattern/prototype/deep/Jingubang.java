package com.example.demo.pattern.prototype.deep;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Jingubang implements Serializable {

    private float h;

    private float r;

    public void bigger(){
        this.h *= 2;
        this.r *= 2;
    }

    public void smaller(){
        this.h /= 2;
        this.r /= 2;
    }

}
