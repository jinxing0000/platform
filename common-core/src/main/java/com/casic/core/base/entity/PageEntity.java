package com.casic.core.base.entity;


import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@SuppressWarnings({"rawtypes", "unchecked"})
public class PageEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    //当前页
    private int currPage;
    //每页的数量
    private int pageSize;
    //总记录数
    private long totalCount;
    //总页数
    private int totalPage;
    //结果集
    private List<T> list;
    //是否为第一页
    private boolean isFirstPage = false;
    //是否为最后一页
    private boolean isLastPage = false;


    public PageEntity() {
    }

    /**
     * 包装Page对象
     *
     * @param list
     */
    public PageEntity(List<T> list) {
        if (list instanceof Page) {
            Page page = (Page) list;
            this.currPage = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.totalPage = page.getPages();
            this.list = page;
            this.totalCount = page.getTotal();
        } else if (list instanceof Collection) {
            this.currPage = 1;
            this.pageSize = list.size();

            this.totalPage = 1;
            this.list = list;
            this.totalCount = list.size();
        }
        if (list instanceof Collection) {
            //判断页面边界
            judgePageBoudary();
        }
    }

    /**
     * 判定页面边界
     */
    private void judgePageBoudary() {
        isFirstPage = currPage == 1;
        isLastPage = currPage == totalPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public boolean isIsFirstPage() {
        return isFirstPage;
    }

    public void setIsFirstPage(boolean isFirstPage) {
        this.isFirstPage = isFirstPage;
    }

    public boolean isIsLastPage() {
        return isLastPage;
    }

    public void setIsLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PageInfo{");
        sb.append("pageNum=").append(currPage);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", total=").append(totalCount);
        sb.append(", pages=").append(totalPage);
        sb.append(", list=").append(list);
        sb.append(", isFirstPage=").append(isFirstPage);
        sb.append(", isLastPage=").append(isLastPage);
        sb.append(", navigatepageNums=");
        sb.append('}');
        return sb.toString();
    }
}