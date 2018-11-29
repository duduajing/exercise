package com.example.demo.pattern.singleton.hungry;
/**
 *
 * 饿汉式单例
 *
 * 它是在类加载的时候就立即初始化，并且创建单例对象
 *  优点： 没有加任何的锁，执行效率比较高，用户体验比较好
 *
 *  缺点： 类加载的时候就初始化，不管你用还是不用，都会占用空间
 *  浪费内存
 *
 *  绝对线程安全，在线程没出现以前就实例化，不可能存在访问安全问题
 *
 * @author dcj
 * @date 2018/11/28 4:46 PM
 * @param
 * @return
 */
public class Hungry {

    private Hungry() {
    }

    /**
     * 类加载的顺序：
     * 先静态，后动态
     * 先属性，后方法
     * 先上后下
     */
    private static final Hungry hungry = new Hungry();


    public static Hungry getInstance(){
        return hungry;
    }
}
