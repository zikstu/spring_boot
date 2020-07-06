package com.medsci.hello.spring.boot.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

/**
    * product
    */
@Data
@Table(name = "product")
public class Product implements Serializable {
    /**
     * id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * productName
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * companyId
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * createdAt
     */
    @Column(name = "created_at")
    private Date createdAt;

    /**
     * updateAt
     */
    @Column(name = "update_at")
    private String updateAt;

    private static final long serialVersionUID = 1L;
}