package com.medsci.hello.spring.boot.service.impl;
import com.medsci.hello.spring.boot.domain.Product;
import java.util.List;

import com.medsci.hello.spring.boot.mapper.ProductMapper;
import com.medsci.hello.spring.boot.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: 学长
 * @date: 2020/7/6 10:49
 */
@Service
public class ProductServiceImpl implements ProductService {
	@Resource
	private ProductMapper productMapper;

	@Override
	public List<Product> findAllByProductNameLike(String likeProductName){
		 return productMapper.findAllByProductNameLike(likeProductName);
	}

}
