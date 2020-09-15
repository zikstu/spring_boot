package com.medsci.hello.spring.boot.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (Users)实体类
 *
 * @author makejava
 * @since 2020-09-11 11:03:03
 */
@Data
@Table(name = "users")
public class Users implements Serializable {
    private static final long serialVersionUID = -83126211077740448L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name;
    
    private String email;
    
    private String password;

    @Column(name = "remember_token")
    private String rememberToken;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Transient
    private List<Role> roles;

    public Users(String name, String email, String password, String rememberToken, Date createdAt, Date updatedAt, List<Role> roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.rememberToken = rememberToken;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.roles = roles;
    }

    public Users(){}

}