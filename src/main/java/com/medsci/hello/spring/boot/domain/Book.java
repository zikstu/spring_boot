package com.medsci.hello.spring.boot.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @author: Arnold
 * @date: 2021/7/8 13:29
 */
@Builder
@Data
public class Book {
    private Integer id;
    private String name;
    private Author author;
    private String publisher;
}
