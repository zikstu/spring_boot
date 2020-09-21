package com.medsci.hello.spring.boot.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.medsci.hello.spring.boot.domain.Orders;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.MyMapper;

@Mapper
public interface OrdersMapper extends MyMapper<Orders> {
    List<Orders> findAllBySource(@Param("source")String source);

    Orders findByCode(@Param("code")String code);

    List<Orders> findAll();



}