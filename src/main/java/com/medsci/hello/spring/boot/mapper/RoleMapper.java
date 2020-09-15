package com.medsci.hello.spring.boot.mapper;
import org.apache.ibatis.annotations.Param;

import com.medsci.hello.spring.boot.domain.Role;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.MyMapper;

/**
 * @description:
 * @author: 学长
 * @date: 2020/9/11 17:15
 */
@Mapper
public interface RoleMapper extends MyMapper<Role> {
    String findNameById(@Param("id")Integer id);
}
