package com.medsci.hello.spring.boot.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.medsci.hello.spring.boot.domain.Author;
import com.medsci.hello.spring.boot.domain.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Arnold
 * @date: 2021/7/8 13:31
 */
@Component
public class BookQueryResolver implements GraphQLQueryResolver {
    public List<Book> findBooks() {
        Author author = Author.builder()
                .id(1)
                .name("Bill Venners")
                .age(40)
                .build();
        Book b = Book.builder()
                .id(1)
                .name("scala编程第三版")
                .author(author)
                .publisher("电子工业出版社")
                .build();
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(b);
        return bookList;
    }
}
