package com.medsci.hello.spring.boot.mapper;
import org.apache.ibatis.annotations.Param;

import com.medsci.hello.spring.boot.domain.Users;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.MyMapper;

/**
 * @description:
 * @author: 学长
 * @date: 2020/9/11 15:35
 */
@Mapper
public interface UsersMapper extends MyMapper<Users> {
    Users findByUserName(String name);

    Users findAllById(@Param("id")Integer id);

    @Override
    int insert(Users users);
}
