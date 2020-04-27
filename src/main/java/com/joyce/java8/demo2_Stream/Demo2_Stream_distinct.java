package com.joyce.java8.demo2_Stream;

import com.joyce.java8.User;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Demo2_Stream_distinct {
    @Test
    public void test_distinct函数去重(){
        Collection<String> list = Arrays.asList("A", "B", "C", "D", "A", "B", "C");
        List<String> distinctElements = list.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctElements); // [A, B, C, D]
    }

    @Test
    public void test_distinct复合对象去重(){
        User lokesh = new User("Lokesh", 10);
        User brian = new User("Brian", 20);
        User alex = new User("Alex", 15);

        //Add some random persons
        Collection<User> list = Arrays.asList(lokesh,brian,alex,lokesh,brian,lokesh);

        // Get distinct objects by key
        List<User> distinctElements = list.stream()
                .filter( distinctByKey(p -> p.getId()) )
                .collect( Collectors.toList() );

        // Let's verify distinct elements
        System.out.println( distinctElements );
    }
    private <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
