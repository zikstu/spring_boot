package com.medsci.hello.spring.boot.domain;
import java.util.List;
import com.medsci.hello.spring.boot.domain.Orders;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "orders")
public class Orders implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 来源
     */
    @Column(name = "`source`")
    private String source;

    /**
     * 支付方式
     */
    @Column(name = "pay_method")
    private String payMethod;

    /**
     * 订单编号
     */
    @Column(name = "code")
    private String code;

    /**
     * 订单金额
     */
    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    private static final long serialVersionUID = 1L;

}