package com.wyw.spring.annotation.service;

import com.wyw.spring.annotation.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/06/15
 */
@Service
public class BookService {
//    @Qualifier
    @Autowired(required = false)
    BookDao bookDao;
}
