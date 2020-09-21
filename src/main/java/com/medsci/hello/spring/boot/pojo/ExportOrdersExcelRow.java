package com.medsci.hello.spring.boot.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description:
 * @author: 学长
 * @date: 2020/9/21 15:01
 */
@Data
public class ExportOrdersExcelRow extends BaseRowModel {
    @ExcelProperty(value = "订单id", index = 0)
    private Integer id;

    @ExcelProperty(value = "订单编号", index = 1)
    private String code;

    @ExcelProperty(value = "订单来源", index = 2)
    private String source;

    @ExcelProperty(value = "支付方式", index = 3)
    private String payMethod;

    @ExcelProperty(value = "订单金额", index = 4)
    private BigDecimal amount;

    @ExcelProperty(value = "创建时间", index = 5)
    private Date createdAt;
}
