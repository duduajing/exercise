package com.example.demo.OverriddenOrOverloaded;

import java.math.BigInteger;
import java.util.*;

/**
 * 重载机制的优化
 */
public class CollectionClassifierTwo {

    public static String classify(Collection<?> c){
        return c instanceof Set ? "Set":
                c instanceof List ? "List" :"Unkown Collection";
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };

        for(Collection<?> c : collections){
            System.out.println(classify(c));
        }
    }
}
