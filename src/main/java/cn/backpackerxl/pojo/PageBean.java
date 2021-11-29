package cn.backpackerxl.pojo;

import cn.backpackerxl.entity.Book;

import java.util.List;

/**
 * @author: backpackerxl
 * @create: 2021/11/28
 * @filename: PageBean
 **/
public class PageBean {
    private List<Book> list;
    private int currentPage;
    private int pageSize;
    private int totalPage;
    private Long totalSize;

    public PageBean(List<Book> list, int currentPage, int pageSize, int totalPage, Long totalSize) {
        this.list = list;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.totalSize = totalSize;
    }

    public PageBean() {
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "list=" + list +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", totalSize=" + totalSize +
                '}';
    }
}
