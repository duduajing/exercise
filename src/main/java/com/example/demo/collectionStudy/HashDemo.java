package com.example.demo.collectionStudy;

import java.util.*;

public class HashDemo {
    protected List usrList = new ArrayList();
    protected java.awt.List visList = new java.awt.List();
    public static void main(String[] args) {
        HashMap h = new HashMap();
        h.put("Adode","Mountail View ,CA");
        h.put("IBM","White Plains, NY");

        String queryString = "IBM";
        System.out.println("You asked about "+queryString+".");
        String resultString = (String) h.get(queryString);
        System.out.println("They are located in: "+resultString);
        System.out.println();
        Collection values = h.values();
        Iterator it = values.iterator();
        while(it.hasNext()){
            String key = (String)it.next();
            System.out.println("Company "+ key +";"+"Address "+h.get(key));
        }
    }
}
