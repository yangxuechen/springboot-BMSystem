package com.njxz.demo.utils.page;

import java.util.List;

/**
 * 分页功能的实现
 * @author yangxuechen
 * @Date 2018/10/30
 * @param <T>
 */
public class Page<T> {
    private List<T> list;//T类型的对象链表
    private int pageNum; //当前页码
    private int pageSize;//每页数量
    private int pageCount;//总页数

    public List<T> getList() {
        return list;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
