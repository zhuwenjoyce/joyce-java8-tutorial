package com.joyce.java8;

import com.alibaba.fastjson.JSONObject;

import java.io.Console;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.junit.Test;

public class Demo1_forEach {
	
	@Test
	public void test_实现Consumer接口() {
		List<String> names = Arrays.asList("Alex", "Brian", "Charles");
		Consumer<String> makeUpperCase = new Consumer<String>() {
		    @Override
		    public void accept(String t) 
		    {
		        System.out.println(t.toUpperCase());
		    }
		};
		names.forEach(makeUpperCase);
		//Console output
//		ALEX
//		BRIAN
//		CHARLES
	}

	@Test
	public void test_过滤数据() {
		List<Integer> numberList = Arrays.asList(1,2,3,4,5);

		Consumer<Integer> action = System.out::println;

		numberList.stream()
				.filter(n -> n%2  == 0)
				.forEach( action );
		//Console output
//		2
//		4
	}
	
	@Test
	public void test_map简单遍历() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("A", "Alex");
		map.put("B", "Brian");
		map.put("C", "Charles");

		map.forEach((k, v) ->
				System.out.println("Key = " + k + ", Value = " + v));

//Console Output
//		Key = A, Value = Alex
//		Key = B, Value = Brian
//		Key = C, Value = Charles
	}

	@Test
	public void test_map键值分开遍历() {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);

//1. Map entries
		Consumer<Map.Entry<String, Integer>> action = System.out::println;
		map.entrySet().forEach(action);
//	Console Output
//	A=1
//	B=2
//	C=3

//2. Map keys
		Consumer<String> actionOnKeys = System.out::println;
		map.keySet().forEach(actionOnKeys);
//	Console Output
//	A
//	B
//	C

//3. Map values
		Consumer<Integer> actionOnValues = System.out::println;
		map.values().forEach(actionOnValues);
		map.forEach((k, v) ->
				System.out.println("Key = " + k + ", Value = " + v));
//	Console Output
//	1
//	2
//	3
	}

	@Test
	public void test_map使用BiConsumer接口遍历() {
		BiConsumer<String, Integer> action = (a, b) -> {
			System.out.println("Key is : " + a);
			System.out.println("Value is : " + b);
		};

		Map<String, Integer> map = new HashMap<>();

		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);

		map.forEach(action);

//Console Output
//		Key is : A
//		Value is : 1
//		Key is : B
//		Value is : 2
//		Key is : C
//		Value is : 3
	}
	
	@Test
	public void test_简单打印() {
		Iterable it; // 这个接口可支持Java8的forEach
		Demo1_forEach demo = new Demo1_forEach();

		List<User> list = new ArrayList<User>();
		list.add(new User("id1",18));
		list.add(new User("id2",22));
		
		list.forEach(u -> u.setAge(u.getAge() + 50));
		list.forEach(u -> demo.print(u));

		list.forEach(System.out::println);
	}
	private void print(User u) {
		System.out.println("print======"+JSONObject.toJSON(u));
	}
}
