package com.example.demo.pattern.singleton.lazy;

/**
 * 懒汉式单例
 *
 * 特点： 在外部类被调用的时候内部类才会被加载
 * 内部类一定是要在方法调用之前初始化
 * 巧妙地避免了线程安全问题
 */
public class LazyThree {


    private boolean initialized = false;

    /**
     * 默认使用LazyThree的时候，会先初始化内部类
     * 如果没使用的话，内部类是不会加载的
     */
    private LazyThree(){

        synchronized (LazyThree.class){
            if(initialized){
                throw new RuntimeException("单例已被侵犯");
            } else{
                initialized = !initialized;
            }
        }
    }

    /**
     * 每个关键字都不是多余的
     * static  是为了使单例的空间共享
     * 保证这个方法不会被重写，重载
     * @return
     */
    public static final LazyThree getInstance(){
        //在返回结果以前，一定会先加载内部类
        return LazyHolder.LAZY;
    }
    //默认不加载
    private static class LazyHolder{
        private static final LazyThree LAZY = new LazyThree();
    }
}
