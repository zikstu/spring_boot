package com.medsci.hello.spring.boot.service.impl;

import com.medsci.hello.spring.boot.domain.User;
import com.medsci.hello.spring.boot.mapper.UserMapper;
import com.medsci.hello.spring.boot.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Senior
 * @date: 2020/4/17 09:06
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> selectUser() {
        List userList = userMapper.selectUser();

        if (userList.isEmpty()){
            return null;
        }

        return userList;
    }

    @Override
    public User findById(Integer id) {
        User user = userMapper.findById(id);

        return user;
    }

    @Override
    public List<User> selectByNameOrSex(User user) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", user.getName());
        map.put("sex", (String) user.getSex());

        List<User> users = userMapper.selectByNameOrSex(map);

        if (users.isEmpty()){
            return null;
        }

        return users;
    }
}
