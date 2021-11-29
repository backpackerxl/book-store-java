package cn.backpackerxl.filter;

import cn.backpackerxl.entity.Book;
import cn.backpackerxl.service.BookService;
import cn.backpackerxl.service.impl.BookUserServiceImp;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.List;

/**
 * @author: backpackerxl
 * @create: 2021/11/27
 * @filename: IndexFilter
 **/
@WebFilter(filterName = "IndexFilter", value = "/index.jsp")
public class IndexFilter implements Filter {
    BookService bookService = new BookUserServiceImp();
    List<Book> bookCharts = bookService.recommendBook(5);
    List<Book> goodBookLists = bookService.recommendBook(8);
    List<Book> bottomBookLists = bookService.recommendBook(4);
    List<Book> bookHots = bookService.recommendBook(1);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setAttribute("bookCharts", bookCharts);
        request.setAttribute("goodBookLists", goodBookLists);
        request.setAttribute("bottomBookLists", bottomBookLists);
        request.setAttribute("bookHots", bookHots);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    public void destroy() {

    }
}
