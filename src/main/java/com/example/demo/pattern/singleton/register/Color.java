package com.example.demo.pattern.singleton.register;
/**
 *
 * 常量中去使用，常量不就是用来大家都能够公用
 * 通常在通用API中使用
 * @author dcj
 * @date 2018/11/28 8:01 PM
 * @param
 * @return
 */
public enum Color {
    RED(){
        private int r = 255;
        private int g = 0;
        private int b = 0;
    },BLACK(){
        private int r = 0;
        private int g = 0;
        private int b = 0;
    },WHITE(){
        private int r = 255;
        private int g = 255;
        private int b = 255;
    };


}
