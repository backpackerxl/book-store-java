package cn.backpackerxl.book.servlet;


import cn.backpackerxl.book.entity.User;
import cn.backpackerxl.book.service.UserService;
import cn.backpackerxl.book.service.impl.UserServiceImp;
import cn.backpackerxl.book.util.StringToJSON;

import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static cn.backpackerxl.book.util.SendEmail.SendEmailInfoUser;

@WebServlet(name = "SendEmailServlet", value = "/sendemail")
public class SendEmailServlet extends HttpServlet {
    private String sendAddress = null;
    private String username;
    private String sendType;
    private String title;
    private String content;
    private String verificationCode;
    private UserService userService;
    private String jsonInfo;
    private HttpSession session;

    /**
     * 随机生成6位数的验证码
     *
     * @return
     */
    private char[] getVerificationCode() {
        String mobile = "0123456789";
        char[] rands = new char[6];
        for (int i = 0; i < 6; i++) {
            int rand = (int) (Math.random() * 9);
            rands[i] = mobile.charAt(rand);
        }
        return rands;
    }

    private void sendRegisterCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        sendAddress = request.getParameter("sendTypeName");
        sendType = request.getParameter("sendType");
        title = "Backpackerxl 书城";
        verificationCode = new String(getVerificationCode());
        session.setAttribute("setRegisterEmailCode", verificationCode);
        content = "您好，您正在注册书城帐号，您的验证码是：" + verificationCode + "请尽快填写，若未请求可能是别人错填了您的邮箱，请忽略此邮件谢谢！\nBackpackerxl账户团队";
        try {
            SendEmailInfoUser(sendAddress, title, content, sendAddress);
            jsonInfo = new StringToJSON("info", "😀 您的邮件已发送，请注意查收，请勿频繁发送，谢谢！").toJSON();
        } catch (MessagingException e) {
            jsonInfo = new StringToJSON("info", ":) 您的邮件发送失败，请60s后重新发送，谢谢！").toJSON();
            e.printStackTrace();
        }
        response.getWriter().append(jsonInfo);
    }

    private void sendForgetCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<User> userList = userService.findByAll();
        username = request.getParameter("sendTypeName");
        int tag = 0;
        for (User user : userList) {
            if (username.equals(user.getName())) {
                tag = 1;
                sendAddress = user.getEmail();
                title = "Backpackerxl 书城";
                verificationCode = new String(getVerificationCode());
                session.setAttribute("setForgetEmailCode", verificationCode);
                content = "尊敬的：" + user.getName() + "，您正在重置您的密码，您的验证码是：" + verificationCode + "请尽快填写，若未请求可能是别人错填了您的邮箱，请忽略此邮件谢谢！\nBackpackerxl账户团队";
                try {
                    SendEmailInfoUser(sendAddress, title, content, sendAddress);
                    jsonInfo = new StringToJSON("info", "😀 您的邮件已发送，请注意查收，请勿频繁发送，谢谢！").toJSON();
                } catch (MessagingException e) {
                    jsonInfo = new StringToJSON("info", ":) 您的邮件发送失败，请60s后重新发送，谢谢！").toJSON();
                    e.printStackTrace();
                }
                break;
            }
        }
        if (tag == 0) {
            jsonInfo = new StringToJSON("info", ":) 此用户尚未注册，请检查您的输入！").toJSON();
        }
        response.getWriter().append(jsonInfo);
        userList.clear();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");//接受数据的编码格式
        response.setContentType("text/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");//响应数据的编码格式
        userService = new UserServiceImp();
        session = request.getSession();
//        System.out.println(this.sendAddress);
        sendType = request.getParameter("sendType");

        //利用反射机制动态处理不同的请求
        try {
            Method method = this.getClass().getDeclaredMethod(sendType, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
