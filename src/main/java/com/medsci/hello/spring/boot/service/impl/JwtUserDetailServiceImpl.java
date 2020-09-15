package com.medsci.hello.spring.boot.service.impl;

import com.medsci.hello.spring.boot.domain.Users;
import com.medsci.hello.spring.boot.mapper.UsersMapper;
import com.medsci.hello.spring.boot.pojo.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * @description:
 * @author: 学长
 * @date: 2020/9/11 15:22
 */
@Service("JwtUserDetailServiceImpl")
public class JwtUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //调用持久层从数据库获取用户信息
        Users user = usersMapper.findByUserName(s);
        if (user == null)
            throw new UsernameNotFoundException("用户名不存在");

        //根据用户id或者用户权限列表
//        List<Role> roles = RoleRepository.findRolesByUserId(user.getId());
//        if (CollectionUtils.isEmpty(roles))
//            roles = Collections.emptyList();
//        user.setRoles(roles);
        return JwtUserFactory.create(user);
    }
}
