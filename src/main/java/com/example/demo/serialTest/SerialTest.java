package com.example.demo.serialTest;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化功能
 */
public class SerialTest {

    public static void main(String[] args) throws Exception {
        Person person = new Person(1234, "du",26);
        System.out.println("Person Serial"+person);
        FileOutputStream fos = new FileOutputStream("Person.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(person);
        oos.flush();
        oos.close();
    }
}
