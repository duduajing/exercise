package com.example.demo.collectionStudy;

import java.util.ArrayList;

public class LinkedListDemo {
    public static void main(String[] args) {
//        System.out.println("Here is a demo of Java 1.2's LinkedList class");
//        LinkedList l = new LinkedList();
//        l.add(new Object());
//        l.add("Hello");
//
//        System.out.println("Here is a list of all the elements");
//
//        //ListIterator is discussed shortly
//        ListIterator li = l.listIterator(0);
//        while (li.hasNext()){
//            System.out.println(li.next());
//        }
//
//        if(l.indexOf("Hello") < 0){
//            System.out.println("Lookup does not work");
//        } else {
//            System.out.println("Lookup works");
//        }

        ArrayList list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        list.subList(0,4).forEach(System.out::println);
    }
}
