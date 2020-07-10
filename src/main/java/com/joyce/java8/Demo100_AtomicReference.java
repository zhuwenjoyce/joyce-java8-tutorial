package com.joyce.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class Demo100_AtomicReference {

    @Test
    public void test_值满足条件才计算() throws MyStringThrowable {
        AtomicReference<Integer> integer = new AtomicReference<>(11);
        Optional<Integer> optionalInteger = Optional.of(integer.get());
        optionalInteger.filter(i -> i > 10).ifPresent(i -> {
            integer.set(integer.get() + 100);
        });
        System.out.println("integer==" + integer); // integer==111
    }
    @Test
    public void test_简单测试() throws MyStringThrowable {
        AtomicReference<List<User>> atomicReference = new AtomicReference<>(new ArrayList<>());
        List<User> userList = atomicReference.get();
        System.out.println("userList==" + userList); // userList==[]
    }
    @Test
    public void test_简单null测试() throws MyStringThrowable {
        AtomicReference<List<User>> atomicReference = new AtomicReference<>();
        List<User> userList = atomicReference.get();
        System.out.println("userList==" + userList); // userList==null
    }

    @Test
    public void test_list满足条件才计算() throws MyStringThrowable {
        // 模拟dao层查询数据
        List<User> users = new ArrayList<>();
        users.add(new User().setId("id1"));

        AtomicReference<List<User>> atomicReference = new AtomicReference<>(new ArrayList<>());

        // 如果dao层有数据则添加
        Optional.of(users)
                .filter(list -> list.size() > 0 )
                .ifPresent(list -> atomicReference.get().addAll(list));

        List<User> userList = atomicReference.get();
        System.out.println("userList==" + userList);
    }
}
