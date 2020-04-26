package com.joyce.java8.demo2;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo2_Stream_skip {

    @Test
    public void test_skip跳过3个数(){
        Stream<Integer> evenNumInfiniteStream = Stream.iterate(0, n -> n + 2);
        List<Integer> newList = evenNumInfiniteStream
                // 如果不跳过任何数，则是： [0, 2, 4, 6, 8, 10, 12, 14, 16, 18]
                // 如果跳过3个数，则是： [6, 8, 10, 12, 14, 16, 18, 20, 22, 24]
                .skip(3)
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(newList);
    }

}
