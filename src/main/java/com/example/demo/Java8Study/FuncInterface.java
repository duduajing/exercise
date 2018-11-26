package com.example.demo.Java8Study;

/**
 * Java 8为函数式接口引入了一个新注解@FunctionalInterface,
 * 主要用于编译级错误检查，加上该注解，当你写的接口不符合函数式
 * 接口定义的时候，编译器会报错。
 * 那什么是函数式接口？函数式接口当然首先式一个接口，然后在这个接口
 * 只能有一个抽象方法，符合了单一职责原则。还解决了默认方法的覆盖问题。
 *
 */
@FunctionalInterface
public interface FuncInterface {
    void test(String txt);
}
