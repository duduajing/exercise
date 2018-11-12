package com.example.demo.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 在方法被调用时，实参通过形参把它的内容副本传入方法内部，此时形参接收到的内容是实参值
 * 的一个拷贝，因此在方法内对形参的任何操作，都仅仅是对这个副本的操作，不影响原始值的内容。
 */
public class BaseJavaUtil {



    public static void main(String[] args) {
//        Map<String, Object> a = new HashMap<>();
//        a.put("name","zs");
//        Map<String, Object> b = new HashMap<>();
//        b.put("name","Ls");
//
//        swap(a, b);
//        System.out.println(a.get("name").toString());
//        System.out.println(b.get("name").toString());

//        String a = "zs";
//        String b = "LS";
//        Map<String,String> result = swapStr(a, b);
//        System.out.println("a = "+result.get("a")+" b= "+result.get("b"));

        String c = "zs";
        String d = "ls";

        swapStrReference(c,d);
        System.out.println(c+" : "+d);
    }

    public static void swap(Map<String, Object> a, Map<String, Object> b){
//        Map<String, Object> temp = new HashMap<>();
        Map<String, Object> temp = a;
//        System.out.println(temp.get("name").toString());
        a = b;
        b = temp;


    }

    public static Map swapStr(String a, String b){



//        String t = new String();
        String t = a;
        a = b;
        b = t;
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("a",a);
        resultMap.put("b", b);
        return resultMap;
    }

    public static void swapStrReference(String a, String b){
        String t = new String("c");
        a = "c";
        b = t;

    }
}
