package com.medsci.hello.spring.boot.service.impl;

import com.medsci.hello.spring.boot.dao.UserRepository;
import com.medsci.hello.spring.boot.domain.Users;
import com.medsci.hello.spring.boot.mapper.UsersMapper;
import com.medsci.hello.spring.boot.service.AuthService;
import com.medsci.hello.spring.boot.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @description:
 * @author: 学长
 * @date: 2020/9/14 10:00
 */
@Service
public class AuthServiceImpl implements AuthService {
    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;
    private UserRepository userRepository;
    private JwtUtil jwtUtil;

    @Autowired
    public AuthServiceImpl(AuthenticationManager authenticationManager, @Qualifier("JwtUserDetailServiceImpl") UserDetailsService userDetailsService, UserRepository userRepository, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    @Autowired
    private UsersMapper usersMapper;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public String login(String username, String password) throws Exception {
        try {
            final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);

            final String token = this.jwtUtil.generateToken(userDetails);

            return token;
        }catch (AuthenticationException authenticationException){
            throw new Exception("登录异常:" + authenticationException.getMessage());
        }
    }

    @Override
    public Integer register(String username, String password) throws Exception {
        Users byUserName = usersMapper.findByUserName(username);

        if(byUserName != null) {
            throw new Exception("用户名已存在");
        }

        Users users = new Users();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        users.setName(username);
        users.setPassword(encoder.encode(password));
        users.setCreatedAt(new Date());
        users.setUpdatedAt(new Date());

        return usersMapper.insert(users);
    }

}
