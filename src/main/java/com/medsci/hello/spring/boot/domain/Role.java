package com.medsci.hello.spring.boot.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: 学长
 * @date: 2020/9/11 11:38
 */
@Data
@Table(name = "roles")
public class Role implements Serializable {
    private static final long serialVersionUID = -1537564713738706818L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}
