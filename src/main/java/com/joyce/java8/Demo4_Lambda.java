package com.joyce.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo4_Lambda {

    @Test
    public void test_线程(){
        new Thread(
                () ->   {
                    System.out.println("My Runnable");
                }
        ).start();
    }

    @Test
    public void test_list循环(){
        List<String> pointList = new ArrayList();
        pointList.add("1");
        pointList.add("2");
        pointList.forEach(p ->  {
                    p = p + 10;
                    System.out.println(p);
                }
        );
    }
    @Test
    public void test_复合对象自定义函数排序(){
        User[] users  = {
                new User("1","David"),
                new User("2","Naveen"),
                new User("3","Alex"),
                new User("4","Richard")};

        System.out.println("Before Sorting Names: "+ Arrays.toString(users));
        Arrays.sort(users, User::nameCompare);
        System.out.println("After Sorting Names "+Arrays.toString(users));
    }

}
