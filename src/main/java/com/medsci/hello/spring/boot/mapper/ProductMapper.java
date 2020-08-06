package com.medsci.hello.spring.boot.mapper;

import com.medsci.hello.spring.boot.dto.ProductDto;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.medsci.hello.spring.boot.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.MyMapper;

@Mapper
public interface ProductMapper extends MyMapper<Product> {
    List<Product> findAllByProductNameLike(@Param("likeProductName")String likeProductName);

    List<Product> productList();

    int insertProduct(Product product);

    int updateByProductId(ProductDto productDto);
}