package cn.backpackerxl.service.impl;

import cn.backpackerxl.dao.BookDao;
import cn.backpackerxl.dao.impl.BookDaoImpl;
import cn.backpackerxl.entity.Book;
import cn.backpackerxl.pojo.BookType;
import cn.backpackerxl.pojo.PageBean;
import cn.backpackerxl.service.BookService;

import java.util.List;

/**
 * @author: backpackerxl
 * @create: 2021/11/22
 * @filename: BookUserServiceImp
 **/
public class BookUserServiceImp implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public List<Book> recommendBook(int limit) {
        return bookDao.recommendBook(limit);
    }

    @Override
    public Book findBookByBookCode(String bookCode) {
        return bookDao.findBookByBookCode(bookCode);
    }

    @Override
    public List<BookType> findBookByType() {
        return bookDao.findBookByType();
    }

    @Override
    public List<Book> findBooksByBookType(int parseInt) {
        return bookDao.findBooksByBookType(parseInt);
    }

    @Override
    public BookType findBookTypeNumbers(int parseInt) {
        return bookDao.findBookTypeNumbers(parseInt);
    }

    @Override
    public List<Book> findBookByName(String keywords) {
        return bookDao.findBookByName(keywords);
    }

    @Override
    public PageBean PageBooks(int currPage, int i) {
        PageBean pageBean = bookDao.PageBooks(currPage, i);
        pageBean.setCurrentPage(currPage);
        pageBean.setTotalSize((long) bookDao.totalPage());
        pageBean.setPageSize(i);
        if (bookDao.totalPage() % i == 0) {
            pageBean.setTotalPage(bookDao.totalPage() / i);
        } else {
            pageBean.setTotalPage(bookDao.totalPage() / i + 1);
        }
        return pageBean;
    }
}
