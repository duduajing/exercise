package com.example.demo.Java8Study;

import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class TestFlatMap {


    public static void main(String[] args) {
//        testFlatMap();
        reduceAdd();
    }

    /**
     *  flatMap方法可用Stream替换值，然后将多个stream 连接成一个Stream
     */
    public static void testFlatMap() {
        Stream.of(asList(1, 2), asList(3, 4))
                .flatMap(nums -> nums.stream())
                .collect(toList())
                .forEach(System.out::println);
    }

    public static void reduceAdd(){
        int result = Stream.of(1, 2, 3, 4)
                .reduce(0, (acc, element) -> acc+element);
        assertEquals(10, result);

    }
}
