package com.medsci.hello.spring.boot.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "`user`")
public class User implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 用户名
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 年龄
     */
    @Column(name = "age")
    private Byte age;

    /**
     * 性别
     */
    @Column(name = "sex")
    private Object sex;

    /**
     * 介绍
     */
    @Column(name = "des")
    private String des;

    /**
     * 状态
     */
    @Column(name = "`status`")
    private Object status;

    /**
     * 创建时间
     */
    @Column(name = "created_at")
    private Date createdAt;

    /**
     * 更新时间
     */
    @Column(name = "updated_at")
    private Date updatedAt;

    private static final long serialVersionUID = 1L;
}