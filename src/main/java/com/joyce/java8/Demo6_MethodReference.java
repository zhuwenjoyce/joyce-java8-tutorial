package com.joyce.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Demo6_MethodReference {

    @Test
    public void test(){
        List<Integer> list = Arrays.asList(1,12,433,5);
        Optional<Integer> max = list.stream().reduce( Math::max );
        max.ifPresent(value -> System.out.println(value)); // 433
    }

    @Test
    public void test1(){
        List<String> strings = Arrays
                .asList("how", "to", "do", "in", "java", "dot", "com");
        List<String> sorted = strings
                .stream()
                .sorted((s1, s2) -> s2.compareTo(s1))
                .collect(Collectors.toList());
        System.out.println(sorted); // [to, java, in, how, dot, do, com]

        List<String> sortedAlt = strings
                .stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        System.out.println(sortedAlt); // [com, do, dot, how, in, java, to]
    }

    @Test
    public void test3(){
        List<Integer> integers = IntStream
                .range(1, 100)
                .boxed()
                .collect(Collectors.toCollection( ArrayList::new ));

        Optional<Integer> max = integers.stream().reduce(Math::max);
        max.ifPresent(System.out::println);
    }

}
