package com.example.demo.OverriddenOrOverloaded;

import java.math.BigInteger;
import java.util.*;

/**
 * 慎用重载机制的原因
 */
public class CollectionClassifier {

    public static String classify(Set<?> s){
        return "set";
    }
    public static String classify(List<?> lst){
        return "List";
    }
    public static String classify(Collection<?> c){
        return "Unknown Collection";
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
