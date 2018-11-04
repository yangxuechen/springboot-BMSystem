package com.njxz.demo.domain.Vo;

import com.njxz.demo.domain.Book;
import com.njxz.demo.domain.User;

import java.util.Date;

/**
 * @author yangxuechen
 * @date 2018/10/12
 * 添加视图层对象
 * @date 2018/11/3
 * 新增属性 user
 */
public class BorrowingBooksVo {
    private User user;
    private Book book;  //借阅书籍
    private String dateOfBorrowing;  //借书日期
    private String dateOfReturn;    //还书日期

    public void setBook(Book book) {
        this.book = book;
    }

    public void setDateOfBorrowing(String dateOfBorrowing) {
        this.dateOfBorrowing = dateOfBorrowing;
    }

    public void setDateOfReturn(String dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public Book getBook() {
        return book;
    }

    public String getDateOfBorrowing() {
        return dateOfBorrowing;
    }

    public String getDateOfReturn() {
        return dateOfReturn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
