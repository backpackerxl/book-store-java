package cn.backpackerxl.service;

import cn.backpackerxl.entity.Book;
import cn.backpackerxl.entity.BookType;

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
}
