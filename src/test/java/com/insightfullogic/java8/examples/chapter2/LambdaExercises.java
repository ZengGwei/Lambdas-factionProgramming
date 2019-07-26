package com.insightfullogic.java8.examples.chapter2;

import com.gw.lambds.chart2.Funcation;
import org.junit.Test;

import javax.swing.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Predicate;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;



public class LambdaExercises {

    @Test
    public void _1a() {
        assertTrue("Shown in the next chapter", true);
    }
/**
*  interface Function<T,R></>{
 *      R appliy(T t);
 *  }
*a 若要编写一个计算器程序，你会使用该接口表示什么样的 Lambda 表达式
*/
    @Test
    public void _1b() {
        // If you were to model each operation on a calculator as a function.
        Function<Double, Double> negate = (x) -> -1 * x;
        Function<Double, Double> square = (x) -> x * x;
        Function<Double, Double> percent = (x) -> 100 * x;


        Funcation<List<Integer> ,Boolean> isEmpty = (x) -> x.isEmpty() ;
        List<Integer> list =  new ArrayList<>();
        list.add(1);

        Boolean apply = isEmpty.apply(list);
        System.out.println(apply);
    }

    @Test
    public void _1c() {
        Function<Integer, Integer> one = x -> x + 1;
        // 2 isn't
        Function<Integer, Boolean> three = x -> x == 1;
    }

    @Test
    public void _2a() {
        assertTrue("ThreadLocal.withInitial", true);
    }

    /**
     * ThreadLocal Lambda 表达式。Java 有一个 ThreadLocal 类，作为容器保存了当前线程里 局部变量的值。
     * Java 8 为该类新加了一个工厂方法，接受一个 Lambda 表达式，并产生 一个新的 ThreadLocal 对象，
     * 而不用使用继承，语法上更加简洁。
     * a. 在 Javadoc 或集成开发环境（IDE）里找出该方法。
     * b. DateFormatter 类是非线程安全的。使用构造函数创建一个线程安全的 DateFormatter 对象，
     * 并输出日期，如“01-Jan-1970”
     */
    @Test
    public void _2b() {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(3);
        User user = new User(18, "zge", "男");

        ThreadLocal<String> stringThreadLocal = ThreadLocal.withInitial(() -> user.toString("aa"));
        System.out.println(stringThreadLocal.get());

        ThreadLocal<DateFormat> threadSafeFormatter = ThreadLocal.withInitial(() -> DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.UK));
        DateFormat formatter = threadSafeFormatter.get();
        assertEquals("01-Jan-1970", formatter.format(new Date(0)));
    }

    @Test
    public void _3a() {
        // yes
        Runnable helloWorld = () -> System.out.println("hello world");
    }

    @Test
    public void _3b() {
        // Yes
        JButton button = new JButton();
        button.addActionListener(event -> System.out.println(event.getActionCommand()));
    }

    @Test
    public void _3c() {
        // No
        // check(x -> x > 5);
    }

    private boolean check(Predicate<Integer> predicate) {
        System.out.println("wat?");
        return true;
    }

    interface IntPred {
        boolean test(Integer value);
    }

    private boolean check(IntPred predicate) {
        return true;
    }

}

class  User {
    private  int age;
    private String name;
    private String felm;

    public User(int age, String name, String felm) {
        this.age = age;
        this.name = name;
        this.felm = felm;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", felm='" + felm + '\'' +
                '}';
    }

    public String toString(String s) {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", felm='" + felm + '\'' +
                '}'+s;
    }

}
