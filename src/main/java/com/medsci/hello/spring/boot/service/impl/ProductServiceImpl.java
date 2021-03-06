package com.medsci.hello.spring.boot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medsci.hello.spring.boot.domain.Product;
import java.util.List;

import com.medsci.hello.spring.boot.dto.ProductDto;
import com.medsci.hello.spring.boot.mapper.ProductMapper;
import com.medsci.hello.spring.boot.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public PageInfo<Product> productList(Integer page, Integer per) {
		PageHelper.startPage(page, per);

		List<Product> list = productMapper.productList();

		PageInfo<Product> pageInfo = new PageInfo<>(list);

		return pageInfo;
	}

	@Override
	public Boolean insert(Product product){
		int insert = productMapper.insertProduct(product);

		if (insert == 1){
			return true;
		}

		return false;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean updateByProductId(ProductDto productDto) {
		int i = productMapper.updateByProductId(productDto);

		if (i > 0){
			return true;
		}

		return false;
	}
}
