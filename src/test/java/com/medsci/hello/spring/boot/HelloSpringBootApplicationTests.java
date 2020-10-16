package com.medsci.hello.spring.boot;

import com.medsci.hello.spring.boot.domain.User;
import com.medsci.hello.spring.boot.mapper.UserMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @Test
    public void array(){
        List<Integer> numbers = Arrays.asList(1,2,2,4);

        List<Integer> newlist = numbers.stream().map(i -> i*i).distinct().collect(Collectors.toList());

        System.out.println(newlist);
    }

    @Test
    public void jsonArray(){
        JSONArray a = new JSONArray();

        a.put("b");
        a.put("c");

        System.out.println(a);
    }

    @Test
    public void jsonObj() throws JSONException {
        JSONObject o = new JSONObject();

        o.put("o", 1);
        o.put("O", 2);
        o.put("1", "o");
        System.out.println(o);
    }
}
