package com.joyce.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

public class Demo8_Optionals {

    @Test
    public void test1(){
        Optional<Integer> optionalInteger = Optional.of(5);
        boolean boo = optionalInteger.isPresent(); 					// returns true
        Integer i = optionalInteger.get(); 							// returns 5
        System.out.println("boo=" + boo + ", i="+i);  // boo=true, i=5

        Optional<Integer> canBeEmpty = Optional.empty();
        boolean boo2 = canBeEmpty.isPresent();
        System.out.println("boo2=" + boo2); // boo2=false
    }

    @Test
    public void test_过滤器(){
        Optional<User> optional = Optional.empty();
        optional = Optional.of(new User("id100","Finance"));
        Consumer<User> consumer = new Consumer<User>() {
            @Override
            public void accept(User t)
            {
                System.out.println(t.getName().toUpperCase());
            }
        };
        optional.filter(u -> "Finance".equals(u.getName())).ifPresent(consumer);
        optional.filter(u -> "Finance".equals(u.getName())).ifPresent(u ->{
            System.out.println(u.getName().toUpperCase());
            return;
        });
        System.out.println("---------------");
        optional.filter(u -> "Finance".equals(u.getName()));
    }

    @Test
    public void test_值可以是null(){
        Optional<Integer> possible1 = Optional.ofNullable(5);
        System.out.println("possible1=" + possible1.get());  // possible1=5

        Optional<Integer> possible2 = Optional.ofNullable(null);
        System.out.println("possible2="+possible2.get());  // java.util.NoSuchElementException: No value present
    }
    @Test
    public void test_判断如果应该存在的值不存在_则返回新值(){
        Optional<User> optionalUser = Optional.empty();
        optionalUser = Optional.of(new User("id1", 18));
        User u1 = optionalUser.orElse(new User("id2",18)); // 如果执行到此行代码时 optionalUser对象为空，则执行else语句替换为id2的user对象，否则返回原对象
//        User u2 = optionalUser.orElseThrow(IllegalStateException::new); // 如果上面的else语句被执行了，则抛出异常
        optionalUser.ifPresent(user -> System.out.println(user.getId())); // 如果存在就执行
        System.out.println(optionalUser.isPresent());
        System.out.println(":::" + Optional.of("").isPresent());
    }
    @Test
    public void test_orElse(){
        Optional.of(
                Optional.of(new User("id100", 18))
                .orElse(new User("id2", 18))
        )
        .ifPresent(user -> System.out.println(user.getId()));
    }
    @Test
    public void test_判断如果应该存在的值不存在() throws MyStringThrowable {
        try{
            User user = new User("id1",18);
            String lock = "lock";
            String unlock = "unlock";
            Optional<String> optional = Optional.of(lock);
            optional.filter(obj -> obj.equalsIgnoreCase("lock2"));
            System.out.println("1");
            System.out.println("2");
            optional.orElseThrow(MyStringThrowable::new);
            System.out.println("3");
        }catch (Throwable e){
            System.out.println("error!");
            e.printStackTrace();
        }
    }

}
