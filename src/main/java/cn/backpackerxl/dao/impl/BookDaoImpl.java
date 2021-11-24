package cn.backpackerxl.dao.impl;

import cn.backpackerxl.dao.BookDao;
import cn.backpackerxl.entity.Book;
import cn.backpackerxl.entity.BookType;
import cn.backpackerxl.util.DButils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: backpackerxl
 * @create: 2021/11/22
 * @filename: BookDaoImpl
 **/
public class BookDaoImpl implements BookDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public List<Book> recommendBook(int limit) {
        List<Book> bookList = new ArrayList<>();
        try {
            String sql = "select * from t_book where book_hot=1 limit ?";
            connection = DButils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, limit);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String bookName = resultSet.getString(2);
                double bookPrice = resultSet.getDouble(3);
                String bookInfo = resultSet.getString(4);
                String bookAuthor = resultSet.getString(5);
                Date createTime = resultSet.getDate(6);
                String bookPublish = resultSet.getString(7);
                double bookSalePrice = resultSet.getDouble(8);
                String bookImg = resultSet.getString(9);
                int typeId = resultSet.getInt(10);
                int bookQuantity = resultSet.getInt(11);
                int bookSaleQty = resultSet.getInt(12);
                int bookHot = resultSet.getInt(13);
                String bookCode = resultSet.getString(14);
                Book book = new Book(id, bookName, bookPrice, bookInfo, bookAuthor, createTime, bookPublish, bookSalePrice, bookImg, typeId, bookQuantity, bookSaleQty, bookHot, bookCode);
                bookList.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DButils.close(connection, preparedStatement, resultSet);
        }
        return bookList;
    }

    @Override
    public Book findBookByBookCode(String bookCode) {
        Book book = null;
        try {
            String sql = "select * from t_book where book_code=?";
            connection = DButils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setNString(1, bookCode);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String bookName = resultSet.getString(2);
                double bookPrice = resultSet.getDouble(3);
                String bookInfo = resultSet.getString(4);
                String bookAuthor = resultSet.getString(5);
                Date createTime = resultSet.getDate(6);
                String bookPublish = resultSet.getString(7);
                double bookSalePrice = resultSet.getDouble(8);
                String bookImg = resultSet.getString(9);
                int typeId = resultSet.getInt(10);
                int bookQuantity = resultSet.getInt(11);
                int bookSaleQty = resultSet.getInt(12);
                int bookHot = resultSet.getInt(13);
                String bookCodes = resultSet.getString(14);
                book = new Book(id, bookName, bookPrice, bookInfo, bookAuthor, createTime, bookPublish, bookSalePrice, bookImg, typeId, bookQuantity, bookSaleQty, bookHot, bookCodes);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DButils.close(connection, preparedStatement, resultSet);
        }
        return book;
    }

    @Override
    public List<BookType> findBookByType() {
        List<BookType> bookTypes = new ArrayList<>();
        try {
            String sql = "select * from t_type";
            connection = DButils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String typeName = resultSet.getString(2);
                bookTypes.add(new BookType(id, typeName));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DButils.close(connection, preparedStatement, resultSet);
        }
        return bookTypes;
    }

}
