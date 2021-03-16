package com.medsci.hello.spring.boot.test;

import java.math.BigDecimal;
import java.util.function.*;

/**
 * @description:
 * @author: 学长
 * @date: 2021/3/10 13:27
 */
public class TestLambda {
    public static void main(String[] args) {
        Predicate<Integer> predicate = x-> x > 185;

        Student student = new Student("学长", 18, 180);

        System.out.println("学长的身高高于185吗？" + predicate.test(student.getStature()));

        Consumer<String> consumer = System.out::println;
        consumer.accept("命由我不由天");

        Function<Student, String> name = Student::getName;
        Function<Student, Integer> age = Student::getAge;

        System.out.println(name.apply(student));
        System.out.println(age.apply(student));

        Supplier<Integer> supplier = () -> Integer.valueOf(BigDecimal.TEN.toString());

        System.out.println(supplier.get());

        UnaryOperator<Boolean> unaryOperator = uglily -> !uglily;

        Boolean apply = unaryOperator.apply(true);

        System.out.println(apply);

        BinaryOperator<Integer> binaryOperator = (x, y) -> x * y;

        System.out.println(binaryOperator.apply(2,4));

        test(() -> "这个是一个函数式接口的演示");
    }

    public static void test(Worker worker){
        String work = worker.work();
        System.out.println(work);
    }

    public interface Worker{
        String work();
    }
}


class Student{
    private String name;

    private Integer age;

    private Integer stature;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getStature() {
        return stature;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setStature(Integer stature) {
        this.stature = stature;
    }

    public Student(String name, Integer age, Integer stature) {
        this.name = name;
        this.age = age;
        this.stature = stature;
    }
}