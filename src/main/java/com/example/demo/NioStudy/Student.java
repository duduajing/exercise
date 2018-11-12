package com.example.demo.NioStudy;

import lombok.Getter;
import lombok.Setter;

import java.util.Vector;
@Setter
@Getter
public class Student implements Cloneable{

    private int id;
    private String name;
    private Vector courses;

    public static void main(String[] args) {
        Student stu1 = new Student();
        Vector cs = new Vector();
        cs.add("Java");
        stu1.setId(1);
        stu1.setName("小明");
        stu1.setCourses(cs);

        Student stu2 = null;
        stu2 = stu1.newInstance();
//        try {
//            stu2 = (Student) stu1.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
        stu2.setId(2);
        stu2.setName("xiao dong ");
        stu2.getCourses().add("C#");

        System.out.println("stu1'name: "+stu1.getName());
        System.out.println("st21'name: "+stu2.getName());
        System.out.println(stu1.getCourses()==stu2.getCourses());

    }

    public Student(){
        try {
            Thread.sleep(1000);
            System.out.println("Student Constructor called");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public Student newInstance(){
        try {
            return (Student) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException{
        Student stu =(Student) super.clone();
        Vector v = stu.getCourses();
        Vector v1 = new Vector();
        for(Object o : v){
           v1.add(o);
        }
        stu.setCourses(v1);
        return stu;
    }
}
