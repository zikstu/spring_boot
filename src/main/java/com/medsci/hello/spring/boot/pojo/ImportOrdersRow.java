package com.medsci.hello.spring.boot.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @description:
 * @author: 学长
 * @date: 2021/1/18 19:15
 */
@Data
public class ImportOrdersRow extends BaseRowModel {
    @ExcelProperty(value = "用户id", index = 1)
    private Integer userId;

    @ExcelProperty(value = "订单编号", index = 2)
    private String code;

    @ExcelProperty(value = "订单来源", index = 3)
    private String source;

    @ExcelProperty(value = "支付方式", index = 4)
    private String payMethod;

    @ExcelProperty(value = "订单金额", index = 5)
    private BigDecimal amount;
}
