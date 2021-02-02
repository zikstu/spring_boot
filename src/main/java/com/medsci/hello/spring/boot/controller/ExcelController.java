package com.medsci.hello.spring.boot.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.google.common.collect.Lists;
import com.medsci.hello.spring.boot.common.ResponseBean;
import com.medsci.hello.spring.boot.domain.Orders;
import com.medsci.hello.spring.boot.pojo.ExportOrdersExcelRow;
import com.medsci.hello.spring.boot.pojo.ImportOrdersRow;
import com.medsci.hello.spring.boot.service.OrdersService;
import com.medsci.hello.spring.boot.utils.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: 学长
 * @date: 2020/9/21 15:32
 */
@RestController
@RequestMapping("/excel")
@Api(tags = "Excel导出")
public class ExcelController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping("/exportExcel")
    @ApiOperationSupport(author = "学长")
    @ApiOperation(value = "订单导出")
    public void exportExcel(HttpServletResponse response) throws IOException {
        List<ExportOrdersExcelRow> list = new ArrayList<>();

        /*获取订单信息*/
        List<Orders> ordersList = ordersService.findAll();

        if (ordersList.isEmpty()){
           throw new IOException("无数据！");
        }

        for (Orders orders: ordersList) {
            ExportOrdersExcelRow excelRow = new ExportOrdersExcelRow();
            excelRow.setId(orders.getId());
            excelRow.setCode(orders.getCode());
            excelRow.setSource(orders.getSource());
            excelRow.setAmount(orders.getAmount());
            excelRow.setPayMethod(orders.getPayMethod());
            excelRow.setCreatedAt(orders.getCreatedAt());
            list.add(excelRow);
        }

        String fileName = "订单信息";
        String sheetName = "订单";

        ExcelUtils.writeExcel(response, list, fileName, sheetName, new ExportOrdersExcelRow());
    }

    @PostMapping("/importExcel")
    @ApiOperationSupport(author = "学长")
    @ApiOperation(value = "excel导入", tags = "excel导入")
    public ResponseBean importExcel(MultipartFile excel){
        List<Object> objectList = ExcelUtils.readExcel(excel, new ImportOrdersRow(), 1, 1);

        List<Orders> ordersList = new ArrayList<>();

        if (objectList == null){
            ResponseBean.error("导入的数据不能为空！");
        }

        return ResponseBean.ok();
    }
}
