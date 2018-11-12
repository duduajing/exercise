package com.example.demo.collectionStudy;

import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet tm = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        tm.add("Gosling");
        tm.add("da Vinci");
        tm.add("Van Gogh");
        tm.add("Java to Go");
        tm.add("Darwin");
        tm.add("Darwin");

        System.out.println("Lowest (alphabetically) is"+tm.first());

        System.out.println(tm.tailSet("k").toArray().length+" elements higher than \"k\"");

        System.out.println("Sorted list: ");
        java.util.Iterator t = tm.iterator();
        t.forEachRemaining(System.out::println);
//        while(t.hasNext()){
//            System.out.println(t.next());
//        }
    }
}
