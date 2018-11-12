package com.example.demo.collectionStudy;

import com.example.demo.util.FileProperties;

import java.io.IOException;
import java.util.Properties;

public class PropsCompanies {

    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        props.setProperty("Adobe","Mountain View, CA");
        props.setProperty("IBM","White Plains, NY");
        props.setProperty("Learning Tree","Los Angeles, CA");
        props.setProperty("O'Reilly & Associates","Sebastopol");

//        props.load(System.in);

        props.list(System.out);

        Properties p = new FileProperties("PropsDemo.dat");
    }
}
