package com.example.demo.pattern.prototype.deep;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Monkey implements Cloneable{

    private int height;

    private int weight;

    protected Date birthday;
}
