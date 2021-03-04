package com.medsci.hello.spring.boot.mapper;
import org.apache.ibatis.annotations.Param;

import com.medsci.hello.spring.boot.domain.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

@Mapper
public interface CompanyMapper extends MyMapper<Company> {
   Company findByCompanyNameAndId(@Param("companyName")String companyName,@Param("id")Integer id);

   @Select("select * from company limit #{limit} ")
   Cursor<Company> scan(@Param("limit") int limit);

   List<Company> select1();
}