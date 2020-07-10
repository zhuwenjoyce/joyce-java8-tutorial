package com.joyce.java8;

import org.junit.Test;

import java.util.Objects;

public class MyTest {
    @Test
    public void test1(){
        String s1 = null;
        String s2 = Objects.requireNonNull(s1);
        System.out.println(s2);
    }
}
