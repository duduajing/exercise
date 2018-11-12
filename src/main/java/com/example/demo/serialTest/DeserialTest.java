package com.example.demo.serialTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 反序列化功能
 */
public class DeserialTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person();
        person.setName("jing");
        FileInputStream fis = new FileInputStream("Person.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        person = (Person) ois.readObject();
        ois.close();
        System.out.println("Person Deserial"+person);

    }
}
