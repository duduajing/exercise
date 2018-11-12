package com.example.demo.collectionStudy;

import java.util.ArrayList;
import java.util.Date;

public class ToArray {

    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add("Blobbo");
        al.add("Cracked");
        al.add("Dumbo");
//        al.add(new Date());
        al.iterator();
        Object[] ol = al.toArray();
        System.out.println("Array of Object has length " + ol.length);

        String[] sl = (String[]) al.toArray(new String[7]);
        System.out.println("Array of String has length " + sl.length);
    }
}
