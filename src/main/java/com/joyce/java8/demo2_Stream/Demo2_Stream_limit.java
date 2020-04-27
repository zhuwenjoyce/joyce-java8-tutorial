package com.joyce.java8.demo2_Stream;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo2_Stream_limit {
    @Test
    public void test_limit10个数(){
        Stream<Integer> evenNumInfiniteStream = Stream.iterate(0, n -> n + 2);
        List<Integer> newList = evenNumInfiniteStream.limit(10)
                .collect(Collectors.toList());
        System.out.println(newList); // [0, 2, 4, 6, 8, 10, 12, 14, 16, 18]
    }

}
