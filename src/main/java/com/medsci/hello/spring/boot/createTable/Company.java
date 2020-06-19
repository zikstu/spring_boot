package com.medsci.hello.spring.boot.createTable;

import java.util.Date;

/**
 * @description:
 * @author: Senior
 * @date: 2020/5/13 15:09
 */
public class Company {
    Integer id;

    /**
     * 名称
     */
    String companyName;

    /**
     * 地址
     */
    String address;

    /**
     * 创建时间
     */
    Date cratedAt;

    /**
     * 更新时间
     */
    Date updatedAt;

}
