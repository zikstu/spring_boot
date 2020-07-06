package com.medsci.hello.spring.boot.controller;

import com.medsci.hello.spring.boot.common.ResponseBean;
import com.medsci.hello.spring.boot.domain.Product;
import com.medsci.hello.spring.boot.service.ProductService;
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
public class ProductController {
    @Autowired
    private ProductService productService;


    @RequestMapping(value = "findAllByProductNameLike", method = RequestMethod.GET)
    public ResponseBean findAllByProductNameLike(@RequestParam(value = "productName") String productName){
        List<Product> allByProductNameLike = productService.findAllByProductNameLike(productName);
        return ResponseBean.ok(allByProductNameLike);
    }
}
