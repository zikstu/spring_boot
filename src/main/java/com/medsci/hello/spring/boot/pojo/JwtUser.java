package com.medsci.hello.spring.boot.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * @description: security需要的UserDetails实现类
 * @author: 学长
 * @date: 2020/9/11 11:18
 */
public class JwtUser implements UserDetails {
    private static final long serialVersionUID = -4959252432107932674L;
    private final long id;
    private final String username;
    private final String password;
    private final Date lastPasswordResetDate;
    /** 权限类.*/
    private final Collection<? extends GrantedAuthority> authorities;

    /**
     * 在createJwtFactory里注入
     */
    public JwtUser(long id,
                   String username,
                   String password,
                   Date lastPasswordResetDate,
                   Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public Date getLastPasswordResetDate(){
        return lastPasswordResetDate;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }
}
