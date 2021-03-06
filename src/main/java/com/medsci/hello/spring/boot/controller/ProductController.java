package com.medsci.hello.spring.boot.controller;

import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.medsci.hello.spring.boot.common.ExceptionEnum;
import com.medsci.hello.spring.boot.common.ResponseBean;
import com.medsci.hello.spring.boot.domain.Product;
import com.medsci.hello.spring.boot.dto.ProductDto;
import com.medsci.hello.spring.boot.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.hasor.web.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @description:
 * @author: 学长
 * @date: 2020/7/6 10:47
 */
@RestController
@RequestMapping("/product")
@Api(tags = "产品相关")
public class ProductController {
    @Autowired
    private ProductService productService;


    @RequestMapping(value = "findAllByProductNameLike", method = RequestMethod.GET)
    @ApiOperation(value = "通过名称搜索", notes = "模糊搜索")
    @ApiOperationSupport(author = "学长")
    public ResponseBean findAllByProductNameLike(@RequestParam(value = "productName") String productName){
        List<Product> allByProductNameLike = productService.findAllByProductNameLike(productName);
        return ResponseBean.ok(allByProductNameLike);
    }

    @RequestMapping(value = "/productList", method = RequestMethod.POST)
    @ApiOperation(value = "产品列表", notes = "支持分页")
    @ApiOperationSupport(author = "学长")
    public ResponseBean productList(@RequestParam(value = "page") Integer page, @RequestParam(value = "per") Integer per){
        PageInfo<Product> pageInfo = productService.productList(page, per);
        return ResponseBean.ok(pageInfo);
    }

    @PostMapping("/store")
    @ApiOperation(value = "添加产品")
    @ApiOperationSupport(author = "学长")
    public ResponseBean insert(@RequestBody Product productData){
        Boolean aBoolean = productService.insert(productData);

        if (aBoolean) {
            return ResponseBean.ok("success");
        }

        return ResponseBean.error(ExceptionEnum.PRODUCT_CREATED_FAIL);
    }

    @PostMapping(path = "/updateByProductId")
    @ApiOperation(value = "更新产品")
    @ApiOperationSupport(author = "学长")
    public ResponseBean updateByProductId(@RequestBody ProductDto productDto){
        try {
            Boolean aBoolean = productService.updateByProductId(productDto);
            if (aBoolean){
                return ResponseBean.ok("success");
            }

            return ResponseBean.error("更新失败！");
        }catch (Exception e){
            System.out.println("Error===" + e.getMessage());
            return ResponseBean.error("未知错误！");
        }
    }
}
