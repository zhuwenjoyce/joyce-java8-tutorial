package com.joyce.java8.demo2_Stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo2_Stream_peek {
    @Test
    public void test_没有其它操作时peek不生效(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream()
                .peek( System.out::println );       //prints nothing
    }

    @Test
    public void test_有其它操作时peek才生效(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> newList = list.stream()
                .peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println(newList);
//        1
//        2
//        3
//        4
//        5
//        [1, 2, 3, 4, 5]
    }
}
