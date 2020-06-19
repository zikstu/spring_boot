package com.medsci.hello.spring.boot.service;

import com.medsci.hello.spring.boot.domain.User;

import java.util.List;


/**
 * @description:
 * @author: Senior
 * @date: 2020/4/17 09:05
 */
public interface UserService {
         List<User> selectUser();

         User findById(Integer id);

         List<User> selectByNameOrSex(User user);

}
