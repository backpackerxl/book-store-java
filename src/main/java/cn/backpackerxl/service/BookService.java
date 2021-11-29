package cn.backpackerxl.service;

import cn.backpackerxl.entity.Book;
import cn.backpackerxl.pojo.BookType;
import cn.backpackerxl.pojo.PageBean;

import java.util.List;

/**
 * @author: backpackerxl
 * @create: 2021/11/22
 * @filename: BookService
 **/
public interface BookService {
    List<Book> recommendBook(int limit);

    Book findBookByBookCode(String bookCode);

    List<BookType> findBookByType();

    List<Book> findBooksByBookType(int parseInt);

    BookType findBookTypeNumbers(int parseInt);

    List<Book> findBookByName(String keywords);

    PageBean PageBooks(int currPage, int i);
}
