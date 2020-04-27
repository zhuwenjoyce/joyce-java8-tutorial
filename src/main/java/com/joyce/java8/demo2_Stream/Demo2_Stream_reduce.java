package com.joyce.java8.demo2_Stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Demo2_Stream_reduce {
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
    public void test_reduce函数1(){ // 与 test_reduce函数2 相同
        Optional<String> optional = memberNames.stream()
                .reduce((s1,s2) -> "||s1=" + s1 + ".s2=" + s2 + "]]]]");
        optional.ifPresent(System.out::println);
        System.out.println(optional.get());
//        Output: ||s1=||s1=||s1=||s1=||s1=||s1=||s1=Amitabh.s2=Shekhar]]]].s2=Aman]]]].s2=Rahul]]]].s2=Shahrukh]]]].s2=Salman]]]].s2=Yana]]]].s2=Lokesh]]]]
    }

    @Test
    public void test_reduce函数2(){
        Optional<String> optional = memberNames.stream()
                .reduce((s1,s2) -> {
                    String val = "||s1=" + s1 + ".s2=" + s2 + "]]]]";
                    System.out.println("val === " + val);
                    return val; // 这里的 val 就是返回的s1的值，会替换s1的值
                });
        optional.ifPresent(System.out::println);
        System.out.println(optional.get());
//        Output: ||s1=||s1=||s1=||s1=||s1=||s1=||s1=Amitabh.s2=Shekhar]]]].s2=Aman]]]].s2=Rahul]]]].s2=Shahrukh]]]].s2=Salman]]]].s2=Yana]]]].s2=Lokesh]]]]
    }

    @Test
    public void test_reduce函数3(){
        Optional accResult = Stream.of(1, 2, 3, 4)
                .reduce((acc, item) -> {
                    System.out.println("acc : "  + acc+", item: " + item);
                    acc = item + 10;
                    System.out.println("acc+ : "  + acc);
                    System.out.println("--------");
                    return acc; // 这里的返回值会替换acc的值
                });
        System.out.println("accResult:::: " + accResult.get());
        System.out.println("--------");
    }

}
