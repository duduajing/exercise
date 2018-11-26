package com.example.demo.Java8Study;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class test {

    public static void main(String[] args) {
        Stream<Integer> s = Stream.of(1,2,3);

        Stream.of(1,2,3).forEach(System.out::println);

    }
}
