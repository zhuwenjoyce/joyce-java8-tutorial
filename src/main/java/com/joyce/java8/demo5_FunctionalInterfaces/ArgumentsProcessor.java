package com.joyce.java8.demo5_FunctionalInterfaces;

@FunctionalInterface
public interface ArgumentsProcessor<Integer>
{
    Integer process(Integer arg1, Integer arg2);
}
