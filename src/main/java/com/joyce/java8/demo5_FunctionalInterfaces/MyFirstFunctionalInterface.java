package com.joyce.java8.demo5_FunctionalInterfaces;

@FunctionalInterface // 这个注释代表这个接口只能有一个方法，一旦存在第二个方法就会报错
public interface MyFirstFunctionalInterface {
    public void firstWork();
//    public void doSomeMoreWork();	//error
}
