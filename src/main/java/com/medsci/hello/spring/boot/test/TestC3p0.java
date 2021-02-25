package com.medsci.hello.spring.boot.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.lang.reflect.Field;
import java.sql.Connection;

/**
 * @description:
 * @author: 学长
 * @date: 2021/2/25 14:30
 */
public class TestC3p0 {
    public static void main(String[] args) throws Exception{
        // 创建数据源
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        // 设置mysql数据库驱动 com.mysql.cj.jdbc.Driver
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");

        // 设置数据库用户名
        dataSource.setUser("root");

        // 设置密码
        dataSource.setPassword("root");

        // 设置数据库连接
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/spring_boot");

        // 设置初始化连接池的大小为1
        dataSource.setInitialPoolSize(1);

        // 设置连接池最大连接数为1
        dataSource.setMaxPoolSize(1);

        // 创建代理的连接对象
        Connection connectionProxy1 = dataSource.getConnection();
        // 真正的连接对象
        Connection inner1 = (Connection) getInner(connectionProxy1);

        // 关闭连接
        connectionProxy1.close();

        Connection connectionProxy2 = dataSource.getConnection();
        // 真正的连接对象
        Connection inner2 = (Connection) getInner(connectionProxy2);

        System.out.println(connectionProxy1.getClass().getName());
        System.out.println(connectionProxy2.getClass().getName());
        System.out.println(connectionProxy1 == connectionProxy2);

        System.out.println(inner1.getClass().getName());
        System.out.println(inner2.getClass().getName());
        System.out.println(inner1 == inner2);
    }


    public static Object getInner(Object connection){
        Object result = null;

        Field field = null;

        try {
            field = connection.getClass().getDeclaredField("inner");
            field.setAccessible(true);
            result = field.get(connection);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return result;
    }
}
