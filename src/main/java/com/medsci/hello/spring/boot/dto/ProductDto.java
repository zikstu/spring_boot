package com.medsci.hello.spring.boot.dto;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;


/**
 * @description:
 * @author: 学长
 * @date: 2020/7/13 11:52
 */
@Getter
@Setter
public class ProductDto {
    @ApiParam(value = "产品ID")
    private Integer id;

    @ApiParam(value = "产品名称")
    private String productName;

    @ApiParam(value = "公司ID")
    private Integer companyId;

    public ProductDto(Integer id, String productName, Integer companyId) {
        this.id = id;
        this.productName = productName;
        this.companyId = companyId;
    }
}
