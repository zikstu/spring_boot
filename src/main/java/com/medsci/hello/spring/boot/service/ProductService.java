package com.medsci.hello.spring.boot.service;

import com.medsci.hello.spring.boot.domain.Product;
import java.util.List;

/**
 * @description:
 * @author: 学长
 * @date: 2020/7/6 10:48
 */
public interface ProductService {
	List<Product> findAllByProductNameLike(String likeProductName);
}
