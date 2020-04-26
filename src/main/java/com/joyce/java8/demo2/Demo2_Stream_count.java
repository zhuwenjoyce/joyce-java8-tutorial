package com.joyce.java8.demo2;

import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo2_Stream_count {
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
    public void test_count函数() {
        long totalMatched = memberNames.stream()
                .filter((s) -> s.startsWith("A"))
                .count();
        System.out.println(totalMatched); // 2
    }
}
