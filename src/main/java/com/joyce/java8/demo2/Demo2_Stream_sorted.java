package com.joyce.java8.demo2;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Demo2_Stream_sorted {
    @Test
    public void test_正序_简单排序(){
        List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
        List<Integer> sortedList = list.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedList); // [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
    @Test
    public void test_倒叙(){
        List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
        List<Integer> sortedList = list.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(sortedList); // [9, 8, 7, 6, 5, 4, 3, 2, 1]
    }
    @Test
    public void test_倒叙_自定义对比(){
        List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
        List<Integer> sortedList = list.stream()
//                .sorted( (i1, i2) -> i2.compareTo(i1) ) // 倒序 [9, 8, 7, 6, 5, 4, 3, 2, 1]
                .sorted( (i1, i2) -> i1.compareTo(i2) ) // 正序 [1, 2, 3, 4, 5, 6, 7, 8, 9]
                .collect(Collectors.toList());
        System.out.println(sortedList);
    }
    @Test
    public void test_自定义函数排序(){
        List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
        Comparator<Integer> reverseComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
//                return i2.compareTo(i1); // 倒序 [9, 8, 7, 6, 5, 4, 3, 2, 1]
                return i1.compareTo(i2); // 正序 [1, 2, 3, 4, 5, 6, 7, 8, 9]
            }
        };
        List<Integer> sortedList = list.stream()
                .sorted(reverseComparator)
                .collect(Collectors.toList());

        System.out.println(sortedList); // [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}
