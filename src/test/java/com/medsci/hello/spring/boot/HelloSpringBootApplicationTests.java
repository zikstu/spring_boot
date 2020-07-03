package com.medsci.hello.spring.boot;

import com.medsci.hello.spring.boot.domain.User;
import com.medsci.hello.spring.boot.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HelloSpringBootApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        System.out.println("hello spring boot.");
    }

    @Test
    public void testSelectAll(){
        List<User> users = userMapper.selectAll();

        users.forEach(user -> {
            System.out.println(user);
        });
    }

    /**
     * bean 生命周期
     */
    public class Person implements BeanNameAware
    {
        private String name;

        /**
         * 实现类上的override
         * @param s
         */
        @Override
        public void setBeanName(String s) {

        }
    }

    /**
     * String 类型
     */
    @Test
    public void str()
    {
        String s1 = new String("java");

        String s2 = s1.intern();

        String s3 = "java";

        System.out.println(s2);
        System.out.println(s1 == s2);
        System.out.println(s3 == s2);
    }
}