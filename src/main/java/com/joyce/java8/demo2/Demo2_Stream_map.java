package com.joyce.java8.demo2;

import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo2_Stream_map {

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
    public void test_list排序() {
        memberNames.stream().sorted() // 排序
                .map(String::toUpperCase)
                .forEach(System.out::println);
//        控制台打印：
//        AMAN
//        AMITABH
//        LOKESH
//        RAHUL
//        SALMAN
//        SHAHRUKH
//        SHEKHAR
//        YANA
    }

    @Test
    public void test_list排序后再转换成list() {
        List<String> memNamesInUppercase = memberNames.stream().sorted()
                .map(String::toUpperCase)
                .collect(Collectors.toList());  // 再转换成list

        System.out.print(memNamesInUppercase);
//      控制台打印: [AMAN, AMITABH, LOKESH, RAHUL, SALMAN, SHAHRUKH, SHEKHAR, YANA]
    }
}
