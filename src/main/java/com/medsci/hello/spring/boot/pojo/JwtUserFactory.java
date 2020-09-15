package com.medsci.hello.spring.boot.pojo;

import com.medsci.hello.spring.boot.domain.Role;
import com.medsci.hello.spring.boot.domain.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: 学长
 * @date: 2020/9/11 11:24
 */
public final class JwtUserFactory {
    private JwtUserFactory() {
    }

    public static JwtUser create(Users user){
        return new JwtUser(
                user.getId(),
                user.getName(),
                user.getPassword(),
                user.getUpdatedAt(),
                map2GrantedAuthorities(user.getRoles())
        );
    }

    /**
     * 将User的List<Role>转换成JwtUser<GrantedAuthority>
     * @param authorities
     * @return
     */
    private static List<GrantedAuthority> map2GrantedAuthorities(List<Role> authorities){
        return authorities.stream()
                .map(e -> role2SimpleGrantedAuthority(e))
                .collect(Collectors.toList());
    }

    private static SimpleGrantedAuthority role2SimpleGrantedAuthority(Role role){
        return new SimpleGrantedAuthority(role.getName());
    }
}
