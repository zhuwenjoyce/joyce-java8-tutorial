package com.joyce.java8.demo7_DefaultMethods;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Animal implements Moveable{

    @Override
    public void move(){
        System.out.println("I am running");
    }

    @Test
    public void test1(){
        Animal tiger = new Animal();
        tiger.move();
    }

    @Test
    public void test2(){
        List<Animal> list = new ArrayList();
        list.add(new Animal());
        list.add(new Animal());
        list.add(new Animal());
        //Iterator code reduced to one line
        list.forEach((Moveable p) -> p.move());
    }


}
