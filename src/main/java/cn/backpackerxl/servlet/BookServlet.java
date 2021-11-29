package cn.backpackerxl.servlet;

import cn.backpackerxl.entity.Book;
import cn.backpackerxl.pojo.BookType;
import cn.backpackerxl.pojo.CommentFactory;
import cn.backpackerxl.pojo.PageBean;
import cn.backpackerxl.service.BookService;
import cn.backpackerxl.service.CommentService;
import cn.backpackerxl.service.impl.BookUserServiceImp;
import cn.backpackerxl.service.impl.CommentServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet(name = "BookServlet", value = "/book")
public class BookServlet extends HttpServlet {
    BookService bookService = new BookUserServiceImp();
    CommentService commentService = new CommentServiceImp();
    List<BookType> bookTypes = bookService.findBookByType();
    List<Book> bottomBookLists = bookService.recommendBook(4);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");//接受数据的编码格式
        response.setContentType("text/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");//响应数据的编码格式

        String actionType = request.getParameter("actionType");
        request.setAttribute("bottomBookLists", bottomBookLists);
        //利用反射机制动态处理不同的请求
        try {
            Method method = this.getClass().getDeclaredMethod(actionType, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookCode = request.getParameter("bookCode");
        Book book = bookService.findBookByBookCode(bookCode);
        List<CommentFactory> commentList = commentService.findAllByBookCode(bookCode);
        request.setAttribute("book", book);
        request.setAttribute("bookTypes", bookTypes);
        request.setAttribute("commentList", commentList);
        request.getRequestDispatcher("/binfo.jsp").forward(request, response);
    }

    public void getBookType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String typeId = request.getParameter("typeId");
        List<Book> bookTypeLists = bookService.findBooksByBookType(Integer.parseInt(typeId));
        BookType bookType = bookService.findBookTypeNumbers(Integer.parseInt(typeId));
        request.setAttribute("bookTypeLists", bookTypeLists);
        request.setAttribute("bookTypes", bookTypes);
        request.setAttribute("bookType", bookType);
        request.getRequestDispatcher("/bshop.jsp").forward(request, response);
    }

    public void searchBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keywords = request.getParameter("keywords");
        List<Book> resBook = bookService.findBookByName(keywords);
        request.setAttribute("resBook", resBook);
        request.setAttribute("keywords", keywords);
        request.getRequestDispatcher("/compoments/bsearch.jsp").forward(request, response);
    }

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currPage = request.getParameter("currPage");
        PageBean pageBooks = bookService.PageBooks(Integer.parseInt(currPage), 12);
        request.setAttribute("pageBooks", pageBooks);
        request.getRequestDispatcher("/compoments/ball.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
