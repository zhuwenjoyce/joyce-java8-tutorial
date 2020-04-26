package com.joyce.java8.demo2;

import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo2_Stream_forEach {
    @Test
    public void test_Stream组装方式一() {
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
        stream.forEach(p -> System.out.println(p));
    }

    @Test
    public void test_Stream组装方式二() {
        Stream<Integer> stream = Stream.of( new Integer[]{1,2,3,4,5,6,7,8,9} );
        stream.forEach(p -> System.out.println(p));
    }

    @Test
    public void test_Stream可以forEach遍历() {
        List<Integer> list = new ArrayList<Integer>();

        for(int i = 10; i< 20; i++){
            list.add(i);
        }

        Stream<Integer> stream = list.stream();
        stream.forEach(p -> System.out.println(p));
    }

    @Test
    public void test_Stream可以generate产生() {
        Stream<Date> stream = Stream.generate(() -> { return new Date(); });
        stream.forEach(p -> System.out.println(p));
        // Stream流只要能读到数据，就能一直打印，所以控制台会一直打印：
//        Sat Apr 25 11:29:43 CST 2020
//        Sat Apr 25 11:29:43 CST 2020
//        Sat Apr 25 11:29:43 CST 2020
//        Sat Apr 25 11:29:43 CST 2020
//        Sat Apr 25 11:29:43 CST 2020
    }


    @Test
    public void test_来源于字符串数组() {
        String[] arr = "A$B$C".split("\\$");
        Stream<String> stream = Stream.of(arr);
        stream.forEach(p -> System.out.println(p));
//        控制台打印：
//        A
//        B
//        C
    }

    @Test
    public void test_来源于字符串() {
        IntStream stream = "12345_abcdefg".chars();
        stream.forEach(p -> System.out.println(p));
//        控制台打印：
//        49
//        50
//        51
//        52
//        53
//        95
//        97
//        98
//        99
//        100
//        101
//        102
//        103
    }

}
