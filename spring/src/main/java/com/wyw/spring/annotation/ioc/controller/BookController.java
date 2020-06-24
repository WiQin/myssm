package com.wyw.spring.annotation.ioc.controller;

import com.wyw.spring.annotation.ioc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/06/15
 */
@Controller
public class BookController {

    @Autowired
    BookService bookService;

    public void print() {
        System.out.println(bookService);
    }
}
