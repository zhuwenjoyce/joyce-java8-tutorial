package com.joyce.java8.demo5_FunctionalInterfaces;

import org.junit.Test;

public class Main {

    @Test
    public void test1(){
        ArgumentsProcessor<Integer> intMultiplier = (i1, i2) -> i1 * i2;
        System.out.println(intMultiplier.process(4, 5));    //20
    }

}
