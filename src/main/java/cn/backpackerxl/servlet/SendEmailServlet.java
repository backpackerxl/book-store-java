package cn.backpackerxl.servlet;


import cn.backpackerxl.entity.User;
import cn.backpackerxl.service.UserService;
import cn.backpackerxl.service.impl.UserServiceImp;
import cn.backpackerxl.util.StringToJSON;

import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static cn.backpackerxl.util.SendEmail.SendEmailInfoUser;

@WebServlet(name = "SendEmailServlet", value = "/sendemail")
public class SendEmailServlet extends HttpServlet {
    private String sendAddress = null;
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
        title = "验证码";
        verificationCode = new String(getVerificationCode());
        session.setAttribute("setRegisterEmailCode", verificationCode);
        content = "<div style=\"width: 100%;box-sizing: border-box;box-shadow: 0 0.5em 1em -0.125em rgba(10 10 10/10%), 0 0 0 1px rgba(10 10 10/2%);border-radius: 5px;padding: 1.5rem;margin: 10px auto; text-align: center; \"><img class=\"book-store\"src=\"https://backpackerxl.gitee.io/image/img/sendEmailBook.png\"><h1 style=\"color: #333;line-height: 1.5rem;\">你的验证码：" + verificationCode + "</h1><p style=\"color: #333;line-height: 1.5rem;\">你好，请在10分钟内输入" + verificationCode + "以认证电子邮件。</p><span style=\"display: block;width: 100%;background: #fe7200;padding: 8px;border-radius: .25rem;color: #fff;box-shadow: 0 0.5em 1em -0.125em rgba(254 115 0/70%), 0 0 0 1px rgba(254 115 0/10%);\">bStore书城提醒您</span><p style=\"color: #333;line-height: 1.5rem;\">此封电子邮件是用于验证你在书城上的注册操作。误收到此邮件?请联系<a style=\"color: #fe7300;\"href=\"https://gitee.com/backpackerxl/image/issues\">bStore支持团队</a></p><div style=\"display: grid;justify-items: center; line-height: 1.5rem;\"><img style=\"width: 64px;\"src=\"https://backpackerxl.gitee.io/image/img/logo.png\"><span>bStore账户团队</span><span><a style=\"color: #fe7300;\"href=\"https://gitee.com/backpackerxl\"><img style=\"width: 25px;\"src=\"https://backpackerxl.gitee.io/image/img/gitee.png\"></a>&nbsp;&nbsp;&nbsp;&nbsp;<a style=\"color: #fe7300;\"href=\"https://github.com/Backpackerxl\"><img style=\"width: 25px;\"src=\"https://backpackerxl.gitee.io/image/img/github.png\"></a></span></div></div>";
        try {
            SendEmailInfoUser(sendAddress, title, content, sendAddress);
            jsonInfo = new StringToJSON("info", "✔ 您的邮件已发送，请注意查收，请勿频繁发送，谢谢！").toJSON();
        } catch (MessagingException e) {
            jsonInfo = new StringToJSON("info", "❌ 您的邮件发送失败，请60s后重新发送，谢谢！").toJSON();
            e.printStackTrace();
        }
        response.getWriter().append(jsonInfo);
    }

    private void sendForgetCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<User> userList = userService.findByAll();
        sendAddress = request.getParameter("sendTypeName");
        int tag = 0;
        for (User user : userList) {
            if (sendAddress.equals(user.getEmail())) {
                tag = 1;
                sendAddress = user.getEmail();
                title = "验证码";
                verificationCode = new String(getVerificationCode());
                content = "<div style=\"width: 100%;box-sizing: border-box;box-shadow: 0 0.5em 1em -0.125em rgba(10 10 10/10%), 0 0 0 1px rgba(10 10 10/2%);border-radius: 5px;padding: 1.5rem;margin: 10px auto; text-align: center; \"><img class=\"book-store\"src=\"https://backpackerxl.gitee.io/image/img/sendEmailBook.png\"><h1 style=\"color: #333;line-height: 1.5rem;\">你的验证码：" + verificationCode + "</h1><p style=\"color: #333;line-height: 1.5rem;\">你好，请在10分钟内输入" + verificationCode + "以认证电子邮件。</p><span style=\"display: block;width: 100%;background: #fe7200;padding: 8px;border-radius: .25rem;color: #fff;box-shadow: 0 0.5em 1em -0.125em rgba(254 115 0/70%), 0 0 0 1px rgba(254 115 0/10%);\">bStore书城提醒您</span><p style=\"color: #333;line-height: 1.5rem;\">此封电子邮件是用于验证你在书城上的找回密码操作。误收到此邮件?请联系<a style=\"color: #fe7300;\"href=\"https://gitee.com/backpackerxl/image/issues\">bStore支持团队</a></p><div style=\"display: grid;justify-items: center; line-height: 1.5rem;\"><img style=\"width: 64px;\"src=\"https://backpackerxl.gitee.io/image/img/logo.png\"><span>bStore账户团队</span><span><a style=\"color: #fe7300;\"href=\"https://gitee.com/backpackerxl\"><img style=\"width: 25px;\"src=\"https://backpackerxl.gitee.io/image/img/gitee.png\"></a>&nbsp;&nbsp;&nbsp;&nbsp;<a style=\"color: #fe7300;\"href=\"https://github.com/Backpackerxl\"><img style=\"width: 25px;\"src=\"https://backpackerxl.gitee.io/image/img/github.png\"></a></span></div></div>";
                session.setAttribute("setForgetEmailCode", verificationCode);
                try {
                    SendEmailInfoUser(sendAddress,title,content,sendAddress);
                    jsonInfo = new StringToJSON("info", "✔ 您的邮件已发送，请注意查收，请勿频繁发送，谢谢！").toJSON();
                } catch (MessagingException e) {
                    jsonInfo = new StringToJSON("info", "❌ 您的邮件发送失败，请60s后重新发送，谢谢！").toJSON();
                    e.printStackTrace();
                }
                break;
            }
        }
        if (tag == 0) {
            jsonInfo = new StringToJSON("info", "❌ 此用户尚未注册，请检查您的输入！").toJSON();
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
