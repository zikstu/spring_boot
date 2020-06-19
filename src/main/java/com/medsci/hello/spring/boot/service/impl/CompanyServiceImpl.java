package com.medsci.hello.spring.boot.service.impl;

import com.medsci.hello.spring.boot.domain.Company;
import com.medsci.hello.spring.boot.mapper.CompanyMapper;
import com.medsci.hello.spring.boot.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Senior
 * @date: 2020/5/13 17:46
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public Company findByCompanyNameAndId(String companyName, Integer Id) {
        Company byCompanyNameAndId = companyMapper.findByCompanyNameAndId(companyName, Id);

        if (byCompanyNameAndId.equals("")){
            return null;
        }

        return byCompanyNameAndId;
    }
}
