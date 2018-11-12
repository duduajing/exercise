package com.example.demo.test;

import java.util.*;

/**
 *
 * 使用工具类Arrays.asList()把数组转换成集合时，不能使用其修
 * 改集合相关的方法， 它的 add/remove/clear 方法会抛出
 * UnsupportedOperationException 异常。
 * @author dcj
 * @date 2018/10/9 下午1:59
 * @param
 * @return
 */
public class ListTest {
    public static void main(String[] args) {
//        String[] str = new String[]{"a", "b"};
//
//        List list = Arrays.asList(str);
//
//       str[0] = "gujin";
//       list.forEach(System.out::println);

        List list = new ArrayList(1000000);
        for(int i = 0; i < 1000000; i++){
            list.add(i+"");
        }
        enhanceForeachList(list);
        foreachList(list);
        iteratorList(list);
        forLoopList(list);


        List lst = new LinkedList();
        for(int i = 0; i < 1000000; i++){
            lst.add(i+"");
        }

//        foreachList(lst);
//        iteratorList(lst);
//        forLoopList(lst);

    }
    public static  void enhanceForeachList(List<String> list){

        long start = System.currentTimeMillis();
        list.forEach(k->{
                k=k;
                });
        System.out.println("foreach spend: " + (System.currentTimeMillis() - start));
    }

    public static  void foreachList(List<String> list){
        String tmp;
        long start = System.currentTimeMillis();
        for(String s : list){
            tmp = s;
        }
        System.out.println("foreach spend: " + (System.currentTimeMillis() - start));
    }

    public static  void iteratorList(List<String> list){
        String tmp;
        long start = System.currentTimeMillis();
        for(Iterator<String> it = list.iterator(); it.hasNext();){
            tmp = it.next();
        }
        System.out.println("iterator spend: " + (System.currentTimeMillis() - start));
    }

    public static  void forLoopList(List<String> list){
        String tmp;
        long start = System.currentTimeMillis();
        int size = list.size();
        for(int i = 0; i < size; i++){
            tmp = list.get(i);
        }
        System.out.println("forLoop spend: " + (System.currentTimeMillis() - start));
    }
}
