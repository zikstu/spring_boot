package com.medsci.hello.spring.boot.mapper;

import com.medsci.hello.spring.boot.domain.User;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.MyMapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper extends MyMapper<User> {
    List<User> selectUser();

    User findById(Integer id);

    List<User> selectByNameOrSex(Map map);

    @Override
    List<User> selectAll();
}