package com.example.demo;

import com.example.demo.serialTest.Person;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class DecimalFormatTest {

    public static void main(String[] args) {
        double pi = 634908;
        DecimalFormat format = new DecimalFormat();
        format.applyPattern("#");
//        System.out.println(new DecimalFormat("0").format(pi));
        System.out.println(format.format(pi).trim());
        double value =1778853;
                System.out.println(" 传入一般的数字类型值： " + value + "]");

        System.out.println(format.format(value).trim());

//        int a = 3,b = 5;
//        int b = a+a++;
//        System.out.println(a-=a+a++);
//        int a-=a=a++;

//        a+=a-=a+a++;
//        System.out.println(a++*b);
        int a=0;
        int b=0;
//        System.out.println(a++);
//        System.out.println(++b);

//        List<Person> pl = new ArrayList<>();
//        pl.add(new Person());
//        pl.add(new Person());
//        Person s = pl.get(1);
//        s.setId(1);
//        List<Person> pl2 = new ArrayList<>();
//
//        for(Person p : pl){
//            Person p11 = p;
//           pl2.add(p);
//           p11.setId(9999);
//           pl2.add(p11);
//        }
//        pl2.forEach(System.out::println);
    }
}
