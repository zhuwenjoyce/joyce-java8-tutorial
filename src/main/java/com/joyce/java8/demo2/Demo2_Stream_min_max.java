package com.joyce.java8.demo2;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class Demo2_Stream_min_max {
    @Test
    public void test_min_max函数(){
        List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
        Optional<Integer> minNumber = list.stream()
                .min((i, j) -> i.compareTo(j));
        Optional<Integer> maxNumber = list.stream()
                .max((i, j) -> i.compareTo(j));
        System.out.println("min="+minNumber.get());
        System.out.println("max="+maxNumber.get());

        Comparator<Integer> minComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                return n1.compareTo(n2);
            }
        };
        Optional<Integer> minNum = list.stream()
                .min(minComparator);
        System.out.println("min===="+minNum.get());
    }
}
