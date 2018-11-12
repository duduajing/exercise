package com.example.demo.StringStudy;

import java.util.Stack;
import java.util.StringTokenizer;

public class StringReverse {

    public static void main(String[] args) {
        String s = "Father Charles Goes Down And Ends Battle";

        //向堆栈中依次压入元素（单词）
        Stack myStack = new Stack();
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens()) {
            myStack.push(st.nextElement());
        }

        System.out.println('"' + s +'"' + "backwards by word is: \n\t\"");
        while (!myStack.empty()){
            System.out.println(myStack.pop());
            System.out.println(' ');
        }
        System.out.println('"');
    }
}
