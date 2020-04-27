package com.joyce.java8.demo2_Stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo2_Stream_match {
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
    public void test_match函数() {
        // 任何一个对象符合，即返回true
        boolean matchedResult = memberNames.stream().anyMatch((s) -> s.startsWith("A"));
        System.out.println(matchedResult);
        // 全部对象符合，即返回true
        matchedResult = memberNames.stream().allMatch((s) -> s.startsWith("A"));
        System.out.println(matchedResult);
        // 没有任何一个对象符合，即返回true
        matchedResult = memberNames.stream().noneMatch((s) -> s.startsWith("A"));
        System.out.println(matchedResult);

//      控制台打印:
//      true
//      false
//      false
    }

    @Test
    public void test_anyMatch函数(){
        boolean matched = memberNames.stream()
                .anyMatch((s) -> s.startsWith("A"));
        System.out.println(matched); // true
    }


}
