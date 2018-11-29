package com.example.demo.pattern.singleton.lazy;

/**
 *
 *  懒汉式单例
 *  在外部需要使用的时候才进行实例化
 *
 * @author dcj
 * @date 2018/11/28 5:14 PM
 * @param
 * @return
 */
public class LazyOne {

    private LazyOne(){}

    //静态块，公共的内存区域
    private static LazyOne lazy = null;

    public static LazyOne getInstance(){
        /**
         * 调用方法之前，先判断
         * 如果没有初始化，将其进行初始化，然后赋值
         * 将该实例缓存好
         */
        if(lazy == null){
            lazy = new LazyOne();
        }
        /* 如果已经初始化，直接返回之前已经保存好的结果*/
        return lazy;
    }
}
