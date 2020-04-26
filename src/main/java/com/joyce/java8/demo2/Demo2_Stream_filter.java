package com.joyce.java8.demo2;

import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo2_Stream_filter {
    @Test
    public void test_Stream和List集合互相转换() {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i< 10; i++){
            list.add(i);
        }
        Stream<Integer> stream = list.stream();
        List<Integer> evenNumbersList = stream.filter(i -> i%2 == 0).collect(Collectors.toList());
        System.out.print(evenNumbersList);
//        控制台打印： [2, 4, 6, 8]
    }

    @Test
    public void test_List集合可以通过Stream转换为数组() {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i< 10; i++){
            list.add(i);
        }
        Stream<Integer> stream = list.stream();
        Integer[] evenNumbersArr = stream.filter(i -> i%2 == 0).toArray(Integer[]::new);
        System.out.print(JSONObject.toJSON(evenNumbersArr));
        // 控制台打印： [2, 4, 6, 8]
    }

    List<String> memberNames = new ArrayList<>();

    @Before
    public void before() {
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");
    }

    @Test
    public void test_List集合过滤() {
        memberNames.stream().filter((s) -> s.startsWith("A"))
                .forEach(System.out::println);
//        控制台打印：
//        Amitabh
//        Aman
    }

    @Test
    public void test_map方法可以调用对象本身的方法() {
        memberNames.stream().filter((s) -> s.startsWith("A"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
//        控制台打印：
//        AMITABH
//        AMAN
    }

    @Test
    public void test_findFirst函数(){
        String firstMatchedName = memberNames.stream()
                .filter((s) -> s.startsWith("L"))
                .findFirst().get();
        System.out.println(firstMatchedName);
//        Output: Lokesh
    }

    @Test
    public void test_parallelStream函数(){
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i< 10; i++){
            list.add(i);
        }
        //Here creating a parallel stream
        Stream<Integer> stream = list.parallelStream();
        Integer[] evenNumbersArr = stream.filter(i -> i%2 == 0).toArray(Integer[]::new);
        System.out.println(evenNumbersArr);
        System.out.println(JSONObject.toJSON(evenNumbersArr));
    }
}
