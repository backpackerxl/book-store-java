package cn.backpackerxl.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static cn.backpackerxl.util.VerificationCode.getVerificationCode;

@WebServlet(name = "VerificationCodeServlet", value = "/verificationcode")
public class VerificationCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getVerificationCode(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
