package com.joyce.java8.demo2_Stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Demo2_Stream_flatMap {
    @Test
    public void test_flatMap函数(){
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4,5,6);
        List<Integer> list3 = Arrays.asList(7,8,9);

        List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);
        List<Integer> listOfAllIntegers = listOfLists.stream()
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
        System.out.println(listOfAllIntegers);
    }
    @Test
    public void test_flatMap函数其实是分开每个对象执行一次(){
        List<String[]> eggs = new ArrayList<>();
        // 第一箱鸡蛋
        eggs.add(new String[]{"鸡蛋_1", "鸡蛋_1", "鸡蛋_1", "鸡蛋_1", "鸡蛋_1"});
        // 第二箱鸡蛋
        eggs.add(new String[]{"鸡蛋_2", "鸡蛋_2", "鸡蛋_2", "鸡蛋_2", "鸡蛋_2"});

        // 自增生成组编号
        AtomicInteger group = new AtomicInteger(1);
        // 自增生成学生编号
        AtomicInteger student = new AtomicInteger(1);
        eggs.stream()
                .map(x -> Arrays.stream(x).map(y -> y.replace("鸡", "煎")))
                .forEach(x -> System.out.println("组" + group.getAndIncrement() + ":" + Arrays.toString(x.toArray())));
         /*
         控制台打印：------------
         组1:[煎蛋_1, 煎蛋_1, 煎蛋_1, 煎蛋_1, 煎蛋_1]
         组2:[煎蛋_2, 煎蛋_2, 煎蛋_2, 煎蛋_2, 煎蛋_2]
          */
        eggs.stream()
                .flatMap(x -> Arrays.stream(x).map(y -> y.replace("鸡", "煎")))
                .forEach(x -> System.out.println("学生" + (student.getAndIncrement()) + ":" + x));
         /*
         控制台打印：------------
         学生1:煎蛋_1
         学生2:煎蛋_1
         学生3:煎蛋_1
         学生4:煎蛋_1
         学生5:煎蛋_1
         学生6:煎蛋_2
         学生7:煎蛋_2
         学生8:煎蛋_2
         学生9:煎蛋_2
         学生10:煎蛋_2
          */
    }
    @Test
    public void test_多维数组转集合(){
        String[][] dataArray = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}, {"g", "h"}};
        List<String> listOfAllChars = Arrays.stream(dataArray)
                .flatMap(x -> Arrays.stream(x))
                .collect(Collectors.toList());
        System.out.println(listOfAllChars); // [a, b, c, d, e, f, g, h]
    }
}
