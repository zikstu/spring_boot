package com.medsci.hello.spring.boot.dao;

import com.medsci.hello.spring.boot.domain.Users;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: 学长
 * @date: 2020/9/11 15:30
 */
@Repository
@Data
public class UserRepository {
    private Map<String, Users> map;

    public UserRepository() {
        map = new HashMap<>();
    }
}
