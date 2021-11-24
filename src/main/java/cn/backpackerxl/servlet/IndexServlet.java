package cn.backpackerxl.servlet;

import cn.backpackerxl.entity.Book;
import cn.backpackerxl.service.BookService;
import cn.backpackerxl.service.impl.BookUserServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet", value = "/")
public class IndexServlet extends HttpServlet {
    BookService bookService = new BookUserServiceImp();
    List<Book> bookCharts = bookService.recommendBook(5);
    List<Book> goodBookLists = bookService.recommendBook(8);
    List<Book> bottomBookLists = bookService.recommendBook(4);
    List<Book> bookHots = bookService.recommendBook(1);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("bookCharts", bookCharts);
        request.setAttribute("goodBookLists", goodBookLists);
        request.setAttribute("bottomBookLists", bottomBookLists);
        request.setAttribute("bookHots", bookHots);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
