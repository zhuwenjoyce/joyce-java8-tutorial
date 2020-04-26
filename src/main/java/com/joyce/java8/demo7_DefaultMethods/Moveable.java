package com.joyce.java8.demo7_DefaultMethods;

public interface Moveable {
    default void move(){
        System.out.println("I am moving");
    }
}
