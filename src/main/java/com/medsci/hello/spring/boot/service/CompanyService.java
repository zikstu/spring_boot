package com.medsci.hello.spring.boot.service;


import com.medsci.hello.spring.boot.domain.Company;

/**
 * @description:
 * @author: Senior
 * @date: 2020/5/13 17:45
 */
public interface CompanyService {
    Company findByCompanyNameAndId(String companyName, Integer Id);
}
