package com.example.demo.OverriddenOrOverloaded;

import java.util.Arrays;

class  Wine{
    String name(){
        return "wine";
    }
}

class SparklingWine extends Wine{
    @Override
    String name(){
        return "SparklingWine";
    }
}

class Champagne extends SparklingWine{
    @Override
    String name(){
        return "Champagne";
    }
}
public class Oerriding {
    public static void main(String[] args) {

        Wine[] wines = {
                new Wine(),new SparklingWine(), new Champagne()
        };

        Arrays.stream(wines).forEach(k->{
            System.out.println(k.name());
        });

    }
}
