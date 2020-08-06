package com.medsci.hello.spring.boot.service;

import com.github.pagehelper.PageInfo;
import com.medsci.hello.spring.boot.domain.Product;
import com.medsci.hello.spring.boot.dto.ProductDto;

import java.util.List;

/**
 * @description:
 * @author: 学长
 * @date: 2020/7/6 10:48
 */
public interface ProductService {
	List<Product> findAllByProductNameLike(String likeProductName);

	PageInfo<Product> productList(Integer page, Integer per);

	Boolean insert(Product product);

	Boolean updateByProductId(ProductDto productDto);
}
