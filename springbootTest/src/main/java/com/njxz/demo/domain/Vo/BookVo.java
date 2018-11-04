package com.njxz.demo.domain.Vo;

public class BookVo {
    private Integer bookId;  //书籍id

    private String bookName; //书名

    private String bookAuthor;//作者

    private String bookPublish;//出版社

    private String isExist;  //是否可借

    public Integer getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookPublish() {
        return bookPublish;
    }

    public String getIsExist() {
        return isExist;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookPublish(String bookPublish) {
        this.bookPublish = bookPublish;
    }

    public void setIsExist(String isExist) {
        this.isExist = isExist;
    }
}
