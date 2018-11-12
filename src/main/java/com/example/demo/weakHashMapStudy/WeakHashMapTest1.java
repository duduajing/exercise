package com.example.demo.weakHashMapStudy;

import lombok.*;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public class WeakHashMapTest1 {

    public static void main(String[] args) {
            WeakHashMapTest1 test1 = new WeakHashMapTest1();
            test1.testWeakReference();
    }

    /**
     * weakHashMap没有进行GC操作.WeakHashMap并不是啥也不干就自动释放内部不用的对象的
     */
    public static void noGc(){
        List<WeakHashMap<byte[][], byte[][]>> maps = new ArrayList<>();
        for(int i = 0; i < 10000; i ++){
            maps.add(getOneWeakHashMap());
            System.gc();
            System.err.println(i);

        }
    }

    /**
     * weakHashMap在访问它的内容的时候释放不用的对象，进行GC操作，
     */
    public static void goGc(){
        List<WeakHashMap<byte[][], byte[][]>> maps = new ArrayList<>();
        for(int i = 0; i < 10000; i ++){
            maps.add(getOneWeakHashMap());
            System.gc();
            System.err.println(i);
            /**
             * 进行如下操作时，key中的byte数组进行了回收,而value依然保持(value被强关联到entry上,entry又关联在map中,map关联在arrayList中.).
             */
            for(int j = 0; j < i; j++){
                System.out.println(j + "size" +maps.get(j).size());
            }
        }
    }

    public static WeakHashMap<byte[][], byte[][]> getOneWeakHashMap(){
        WeakHashMap<byte[][], byte[][]> d = new WeakHashMap<byte[][], byte[][]>();
        d.put(new byte[100000][10000], new byte[10000][10000]);
        return d;
    }

    public  void testWeakReference(){
        WeakHashMap<Integer, WeakReference<Person>> map = new WeakHashMap<Integer,WeakReference<Person>>();

        Person p1=new Person("robin",1,28);
        Person p2=new Person("robin",2,29);
        Person p3=new Person("harry",3,30);
        map.put(new Integer(100), new WeakReference<Person>(p1));
        map.put(new Integer(101), new WeakReference<Person>(p2));
        map.put(new Integer(1), new WeakReference<Person>(p3));
        for(WeakReference<Person> rp:map.values())
        {
            Person p= rp.get();
            System.out.println("people:"+p);
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    class Person{
        String name;
        int id;
        int age;

        public Person(String name, int id) {
           this(name,id,0);
        }

        @Override
        public boolean equals(Object o){
            if(o == null){
                return false;
            }

            if(!(o instanceof Person)){
                return false;
            }
            Person p = (Person) o;
            boolean res = name.equals(p.name);
            if(res){
                System.out.println("name "+ name +" is double");
            }else{
                System.out.println(name+" vS "+p.name);

            }
            return res;
        }

        @Override
        public int hashCode(){
            return name.hashCode();
        }
    }

}
