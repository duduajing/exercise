package com.example.demo.EnumStudy;

import java.util.HashMap;
import java.util.Map;

public enum Operation {
    PLUS("+"){
        @Override
       double apply(double x, double y){
           return x+y;
       }
    },
    MINUS("-"){
        @Override
        double apply(double x, double y){
            return x-y;
        }
    },
    TIMES("*"){
        @Override
        double apply(double x, double y){
            return x*y;
        }
    },
    DIVIDE("/"){
        @Override
        double apply(double x, double y){
            return x/y;
        }
    };

    private final String symbol;
    Operation(String symbol){
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    abstract double apply(double x, double y);

    private static final Map<String, Operation> stringToEnum
            = new HashMap<String, Operation>();

    /**
     * Operation常量从静态代码块中被放入到stringToEnum的map中。
     */
    static {
        for(Operation op : values()){
            stringToEnum.put(op.toString(), op);
        }
    }

    public static Operation fromString(String symbol){
        return stringToEnum.get(symbol);
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        for(Operation op : Operation.values()){
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x,y));
        }
    }
}
