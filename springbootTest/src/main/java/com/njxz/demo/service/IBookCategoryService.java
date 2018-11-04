package com.njxz.demo.service;

import com.njxz.demo.domain.BookCategory;
import com.njxz.demo.utils.page.Page;

public interface IBookCategoryService {

    //图书类别分页查询
    public Page<BookCategory> selectBookCategoryByPageNum(int pageNum);

    int deleteBookCategoryById(int bookCategoryId);
}
