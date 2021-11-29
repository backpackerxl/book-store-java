package cn.backpackerxl.dao.impl;

import cn.backpackerxl.dao.BookDao;
import cn.backpackerxl.entity.Book;
import cn.backpackerxl.pojo.BookType;
import cn.backpackerxl.pojo.PageBean;
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
            String sql = "select tp.id, tp.type_name, count(tb.type_id) from t_type tp left join t_book tb on tp.id = tb.type_id group by tp.id";
            connection = DButils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String typeName = resultSet.getString(2);
                int number = resultSet.getInt(3);
                bookTypes.add(new BookType(id, typeName, number));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DButils.close(connection, preparedStatement, resultSet);
        }
        return bookTypes;
    }

    @Override
    public List<Book> findBooksByBookType(int parseInt) {
        List<Book> bookTypeList = new ArrayList<>();
        try {
            connection = DButils.getConnection();
            preparedStatement = connection.prepareStatement("select * from t_book where type_id = ?");
            preparedStatement.setInt(1, parseInt);
            ResultSet resultSet = preparedStatement.executeQuery();
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
                String bookCodes = resultSet.getString(14);
                Book book = new Book(id, bookName, bookPrice, bookInfo, bookAuthor, createTime, bookPublish, bookSalePrice, bookImg, typeId, bookQuantity, bookSaleQty, bookHot, bookCodes);
                bookTypeList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButils.close(connection, preparedStatement, resultSet);
        }
        return bookTypeList;
    }

    @Override
    public BookType findBookTypeNumbers(int parseInt) {
        BookType bookType = null;
        try {
            connection = DButils.getConnection();
            preparedStatement = connection.prepareStatement("select tp.id, tp.type_name, count(tb.type_id) from t_type tp left join t_book tb on tp.id = tb.type_id where tp.id = ? group by tp.id;");
            preparedStatement.setInt(1, parseInt);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String typeName = resultSet.getString(2);
                int number = resultSet.getInt(3);
                bookType = new BookType(id, typeName, number);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButils.close(connection, preparedStatement, resultSet);
        }
        return bookType;
    }

    @Override
    public List<Book> findBookByName(String keywords) {
        List<Book> resBook = new ArrayList<>();
        try {
            String sql = "select * from t_book where book_name like '%" + keywords + "%'";
            connection = DButils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
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
                String bookCodes = resultSet.getString(14);
                Book book = new Book(id, bookName, bookPrice, bookInfo, bookAuthor, createTime, bookPublish, bookSalePrice, bookImg, typeId, bookQuantity, bookSaleQty, bookHot, bookCodes);
                resBook.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButils.close(connection, preparedStatement, resultSet);
        }
        return resBook;
    }

    public int totalPage() {
        int num = 0;
        try {
            connection = DButils.getConnection();
            preparedStatement = connection.prepareStatement("select count(*) from t_book");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                num = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButils.close(connection, preparedStatement, resultSet);
        }
        return num;
    }

    @Override
    public PageBean PageBooks(int currPage, int i) {
        PageBean pageBeans = new PageBean();
        List<Book> temp = new ArrayList<>();
        int start = (currPage - 1) * i;
        try {
            connection = DButils.getConnection();
            preparedStatement = connection.prepareStatement("select * from t_book limit ?,?");
            preparedStatement.setInt(1, start);
            preparedStatement.setInt(2, i);
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
                String bookCodes = resultSet.getString(14);
                Book book = new Book(id, bookName, bookPrice, bookInfo, bookAuthor, createTime, bookPublish, bookSalePrice, bookImg, typeId, bookQuantity, bookSaleQty, bookHot, bookCodes);
                temp.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButils.close(connection, preparedStatement, resultSet);
        }
        pageBeans.setList(temp);
        return pageBeans;
    }
}
