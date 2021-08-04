package com.medsci.hello.spring.boot.test;

/**
 * @author: Arnold
 * @date: 2021/7/22 14:18
 */
public class TestInstance {
    private String name;
    private int age;

    public TestInstance() {
        this.name = "default";
        this.age = 0;
    }

    public TestInstance(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void info() {
        System.out.println("My name is " + name + ", I'm " + age + " years old.");
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // copy reference
        TestInstance p2 = (TestInstance)Class.forName("com.medsci.hello.spring.boot.test.TestInstance").newInstance();
        TestInstance p3 = TestInstance.class.newInstance();

        p2.info();
        p3.info();
    }

}
