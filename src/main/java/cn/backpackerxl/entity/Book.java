package cn.backpackerxl.entity;

import java.util.Date;

/**
 * @author: backpackerxl
 * @create: 2021/11/22
 * @filename: Book
 **/
public class Book {
    private int id;
    private String bookName;
    private double bookPrice;
    private String bookInfo;
    private String bookAuthor;
    private Date createTime;
    private String bookPublish;
    private double bookSalePrice;
    private String bookImg;
    private int typeId;
    private int bookQuantity;
    private int bookSaleQty;
    private int bookHot;
    private String bookCode;

    public Book(int id, String bookName, double bookPrice, String bookInfo, String bookAuthor, Date createTime, String bookPublish, double bookSalePrice, String bookImg, int typeId, int bookQuantity, int bookSaleQty, int bookHot, String bookCode) {
        this.id = id;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookInfo = bookInfo;
        this.bookAuthor = bookAuthor;
        this.createTime = createTime;
        this.bookPublish = bookPublish;
        this.bookSalePrice = bookSalePrice;
        this.bookImg = bookImg;
        this.typeId = typeId;
        this.bookQuantity = bookQuantity;
        this.bookSaleQty = bookSaleQty;
        this.bookHot = bookHot;
        this.bookCode = bookCode;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(String bookInfo) {
        this.bookInfo = bookInfo;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBookPublish() {
        return bookPublish;
    }

    public void setBookPublish(String bookPublish) {
        this.bookPublish = bookPublish;
    }

    public double getBookSalePrice() {
        return bookSalePrice;
    }

    public void setBookSalePrice(double bookSalePrice) {
        this.bookSalePrice = bookSalePrice;
    }

    public String getBookImg() {
        return bookImg;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public int getBookSaleQty() {
        return bookSaleQty;
    }

    public void setBookSaleQty(int bookSaleQty) {
        this.bookSaleQty = bookSaleQty;
    }

    public int getBookHot() {
        return bookHot;
    }

    public void setBookHot(int bookHot) {
        this.bookHot = bookHot;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookInfo='" + bookInfo + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", createTime=" + createTime +
                ", bookPublish='" + bookPublish + '\'' +
                ", bookSalePrice=" + bookSalePrice +
                ", bookImg='" + bookImg + '\'' +
                ", typeId=" + typeId +
                ", bookQuantity=" + bookQuantity +
                ", bookSaleQty=" + bookSaleQty +
                ", bookHot=" + bookHot +
                ", bookCode='" + bookCode + '\'' +
                '}';
    }
}
