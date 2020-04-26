package com.joyce.java8;

import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.*;

public class Demo3_BoxedStream {
    @Test
    public void 简单知识(){
        List<String> strings = Stream.of("how", "to", "do", "in", "java")
                .collect(Collectors.toList());
        System.out.println(strings); // [how, to, do, in, java]
    }
    @Test
    public void test_int例子(){
        List<Integer> ints = IntStream.of(1,2,3,4,5) // IntStream 必须与boxed()函数配合使用，否则会报错
                .boxed()
                .collect(Collectors.toList());
        System.out.println(ints); // [1, 2, 3, 4, 5]

        Optional<Integer> max = IntStream.of(1,30,2,3,4,5)
                .boxed()
                .max(Integer::compareTo);
        System.out.println(max.get()); // 30

        Optional<Integer> min = IntStream.of(1,30,2,-1,3,4,5)
                .boxed()
                .min(Integer::compareTo);
        System.out.println(min.get()); // -1
    }
    @Test
    public void test_long例子(){
        List<Long> longs = LongStream.of(1l,2l,3l,4l,5l)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(longs); // [1, 2, 3, 4, 5]
    }
    @Test
    public void test_double例子(){
        List<Double> doubles = DoubleStream.of(1d,2d,3d,4d,5d)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(doubles); // [1.0, 2.0, 3.0, 4.0, 5.0]
    }
}
