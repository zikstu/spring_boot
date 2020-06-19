package com.medsci.hello.spring.boot.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

/**
 * company
 */
@Data
@Table(name = "company")
public class Company implements Serializable {
    /**
     * id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 创建时间
     */
    @Column(name = "crated_at")
    private Date cratedAt;

    /**
     * 更新时间
     */
    @Column(name = "updated_at")
    private Date updatedAt;

    private static final long serialVersionUID = 1L;
}