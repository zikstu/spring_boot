package com.medsci.hello.spring.boot.mapper;
import org.apache.ibatis.annotations.Param;

import com.medsci.hello.spring.boot.domain.Company;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.MyMapper;

@Mapper
public interface CompanyMapper extends MyMapper<Company> {
   Company findByCompanyNameAndId(@Param("companyName")String companyName,@Param("id")Integer id);
}