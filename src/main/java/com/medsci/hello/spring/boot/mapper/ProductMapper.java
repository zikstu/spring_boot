package com.medsci.hello.spring.boot.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.medsci.hello.spring.boot.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.MyMapper;

@Mapper
public interface ProductMapper<findAllByProductNameLike> extends MyMapper<Product> {
    List<Product> findAllByProductNameLike(@Param("likeProductName")String likeProductName);

    List<Product> productList();
}