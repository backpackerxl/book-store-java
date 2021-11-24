package cn.backpackerxl.service.impl;

import cn.backpackerxl.dao.BookDao;
import cn.backpackerxl.dao.impl.BookDaoImpl;
import cn.backpackerxl.entity.Book;
import cn.backpackerxl.entity.BookType;
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


}
