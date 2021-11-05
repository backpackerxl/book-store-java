package cn.backpackerxl.book.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static cn.backpackerxl.book.util.VerificationCode.getVerificationCode;

@WebServlet(name = "VerificationCodeServlet", value = "/verificationcode")
public class VerificationCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
        getVerificationCode(request, response);
//        System.out.println(session.getAttribute("checkLoginCode"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
