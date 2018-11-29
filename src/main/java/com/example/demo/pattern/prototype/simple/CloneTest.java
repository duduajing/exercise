package com.example.demo.pattern.prototype.simple;

import java.util.ArrayList;
import java.util.List;

/***
 *
 * 浅拷贝和深拷贝
 * 浅拷贝: clone 后的对象引用同一个对象
 * 深拷贝: 保证每个属性都是独立的，拷贝的是对象的值
 * @author dcj
 * @date 2018/11/29 3:18 PM
 * @param
 * @return
 */
public class CloneTest {

    public static void main(String[] args) {


        CloneTarget p = new CloneTarget();
        p.setName("tom");
        List<CloneTarget> listClone = new ArrayList<>();
        listClone.add(new CloneTarget());
        p.setTarget(new CloneTarget());
        p.setList(listClone);
        CloneTarget t = p.getTarget();
        System.out.println(t);

        try {
            CloneTarget obj = (CloneTarget)p.clone();
            obj.getList().add(new CloneTarget());
            System.out.println( p.getList().size());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
