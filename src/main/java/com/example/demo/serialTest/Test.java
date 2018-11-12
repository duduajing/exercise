package com.example.demo.serialTest;

import java.io.*;

public class Test implements Serializable {

    private static final long serialVersionUID = 1L;

    public static int staticVar = 5;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("result.obj")
        );
        out.writeObject(new Test());
        out.close();

        Test.staticVar = 10;

        ObjectInputStream oin = new ObjectInputStream(
                new FileInputStream("result.obj"));
        Test t = (Test)oin.readObject();
        oin.close();


    }
}
