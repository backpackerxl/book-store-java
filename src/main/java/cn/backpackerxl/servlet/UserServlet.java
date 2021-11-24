package cn.backpackerxl.servlet;

/**
 * @author: backpackerxl
 * @create: 2021/10/28
 * @filename: LoginServlet
 **/


import cn.backpackerxl.entity.User;
import cn.backpackerxl.service.UserService;
import cn.backpackerxl.service.impl.UserServiceImp;
import cn.backpackerxl.util.StringToJSON;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static cn.backpackerxl.util.MD5Utils.code;
import static cn.backpackerxl.util.SendEmail.SendEmailInfoUser;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private HttpSession session;
    private String methodName;
    private Method method = null;
    private UserService userService;
    private List<User> userList;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * 注册用户时的检查手机号接口
     *
     * @param request
     * @param response
     */
    private void registerCheckPhone(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String phone = request.getParameter("type");
        for (User user : userList) {
            if (phone.equals(user.getPhone())) {
                response.getWriter().append(new StringToJSON("info", "此手机号已被注册").toJSON());
                break;
            }
        }
    }

    /**
     * 注册用户时的检查用户名的接口
     *
     * @param request
     * @param response
     */
    private void registerCheckUsername(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("type");
        for (User user : userList) {
            if (username.equals(user.getName())) {
                response.getWriter().append(new StringToJSON("info", "此用户名已被注册").toJSON());
                break;
            }
        }
    }

    /**
     * 注册用户时的检查邮箱接口
     *
     * @param request
     * @param response
     */
    private void registerCheckEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("type");
        for (User user : userList) {
            if (email.equals(user.getEmail())) {
                response.getWriter().append(new StringToJSON("info", "此邮箱号已被注册").toJSON());
                break;
            }
        }
    }

    /**
     * 用户注册的处理方法
     *
     * @param request
     * @param response
     */
    private void userRegister(HttpServletRequest request, HttpServletResponse response) throws IOException, MessagingException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String info = request.getParameter("info");
        String checkcode = request.getParameter("checkcode");

        User user = new User();
        user.setName(username);
        user.setPasswd(code(password));
        user.setPhone(phone);
        user.setEmail(email);
        user.setInfo(info);
        user.setUserImg("/img/buser/avater.jpg");
        user.setUserMoney(0.00);
        if (checkcode.equals(session.getAttribute("setRegisterEmailCode"))) {
            session.removeAttribute("setRegisterEmailCode");
            int blog = userService.registerUser(user);
            if (blog == 0) {
                response.sendRedirect(request.getContextPath()+"/register?error=service");
            } else {
                response.sendRedirect(request.getContextPath()+"/login");
                String content = "<div style=\"width: 100%;box-sizing: border-box;box-shadow: 0 0.5em 1em -0.125em rgba(10 10 10/10%), 0 0 0 1px rgba(10 10 10/2%);border-radius: 5px;padding: 1.5rem;margin: 10px auto; text-align: center; \"><img class=\"book-store\"src=\"https://backpackerxl.gitee.io/image/img/sendEmailBook.png\"><span style=\"display: block;width: 100%;background: #fe7200;padding: 8px;border-radius: .25rem;color: #fff;box-shadow: 0 0.5em 1em -0.125em rgba(254 115 0/70%), 0 0 0 1px rgba(254 115 0/10%);\">bStore书城提醒您</span><p style=\"color: #333;line-height: 1.5rem;\">尊敬的"+user.getName()+",您已经在书城成功注册了一个帐号。如有疑问请联系<a style=\"color: #fe7300;\"href=\"https://gitee.com/backpackerxl/image/issues\">bStore支持团队</a></p><div style=\"display: grid;justify-items: center; line-height: 1.5rem;\"><img style=\"width: 64px;\"src=\"https://backpackerxl.gitee.io/image/img/logo.png\"><span>bStore账户团队</span><span><a style=\"color: #fe7300;\"href=\"https://gitee.com/backpackerxl\"><img style=\"width: 25px;\"src=\"https://backpackerxl.gitee.io/image/img/gitee.png\"></a>&nbsp;&nbsp;&nbsp;&nbsp;<a style=\"color: #fe7300;\"href=\"https://github.com/Backpackerxl\"><img style=\"width: 25px;\"src=\"https://backpackerxl.gitee.io/image/img/github.png\"></a></span></div></div>";
                SendEmailInfoUser(email, "Backpackerxl 书城", content, email);
                userList.clear();
            }
        } else {
            response.sendRedirect(request.getContextPath()+"/register?error=code");
        }
    }

    /**
     * 用户找回密码的处理方法
     *
     * @param request
     * @param response
     */
    private void userForget(HttpServletRequest request, HttpServletResponse response) throws IOException, MessagingException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkcode = request.getParameter("checkcode");
        User user = new User();
        for (User user1 : userList) {
            if (username.equals(user1.getEmail())) {
                user = user1;
                break;
            }
        }
        if (checkcode.equals(session.getAttribute("setForgetEmailCode"))) {
            session.removeAttribute("setForgetEmailCode");
            user.setPasswd(code(password));
            int target = userService.UpdataUser(user);
            if (target == 0) {
                response.sendRedirect(request.getContextPath()+"/forget?error=service");
            } else {
                response.sendRedirect(request.getContextPath()+"/login");
                String content = "<div style=\"width: 100%;box-sizing: border-box;box-shadow: 0 0.5em 1em -0.125em rgba(10 10 10/10%), 0 0 0 1px rgba(10 10 10/2%);border-radius: 5px;padding: 1.5rem;margin: 10px auto; text-align: center; \"><img class=\"book-store\"src=\"https://backpackerxl.gitee.io/image/img/sendEmailBook.png\"><span style=\"display: block;width: 100%;background: #fe7200;padding: 8px;border-radius: .25rem;color: #fff;box-shadow: 0 0.5em 1em -0.125em rgba(254 115 0/70%), 0 0 0 1px rgba(254 115 0/10%);\">bStore书城提醒您</span><p style=\"color: #333;line-height: 1.5rem;\">尊敬的"+user.getName()+",您已经在书城成功找回了您的帐号。如有疑问请联系<a style=\"color: #fe7300;\"href=\"https://gitee.com/backpackerxl/image/issues\">bStore支持团队</a></p><div style=\"display: grid;justify-items: center; line-height: 1.5rem;\"><img style=\"width: 64px;\"src=\"https://backpackerxl.gitee.io/image/img/logo.png\"><span>bStore账户团队</span><span><a style=\"color: #fe7300;\"href=\"https://gitee.com/backpackerxl\"><img style=\"width: 25px;\"src=\"https://backpackerxl.gitee.io/image/img/gitee.png\"></a>&nbsp;&nbsp;&nbsp;&nbsp;<a style=\"color: #fe7300;\"href=\"https://github.com/Backpackerxl\"><img style=\"width: 25px;\"src=\"https://backpackerxl.gitee.io/image/img/github.png\"></a></span></div></div>";
                SendEmailInfoUser(user.getEmail(), "Backpackerxl 书城", content, user.getEmail());
                userList.clear();
            }
        } else {
            response.sendRedirect(request.getContextPath()+"/forget?error=code");
        }
    }

    /**
     * 用户登录的处理方法
     *
     * @param request
     * @param response
     * @throws IOException
     */
    private void userLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkcode = request.getParameter("checkcode");
        userService = new UserServiceImp();
        User user = userService.findByName(username);
        if (user == null) {
            response.sendRedirect(request.getContextPath()+"/login?error=yes");
            return;
        }
        if (user.getPasswd().equals(code(password)) && checkcode.equals(session.getAttribute("checkLoginCode"))) {
            session.removeAttribute("checkLoginCode");
            user.setPasswd("");
            session.setAttribute("username", user.getName());
            session.setAttribute("userid", user.getId());
            session.setAttribute("userImg", user.getUserImg());
            response.sendRedirect(request.getContextPath());
        } else {
            response.sendRedirect(request.getContextPath()+"/login?error=yes");
        }
    }

    /**
     * 用户退出
     * @param request
     * @param response
     * @throws IOException
     */
    public void loginOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        session.removeAttribute("username");
        session.removeAttribute("userid");
        session.removeAttribute("userImg");
        response.sendRedirect(request.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");//接受数据的编码格式
        response.setContentType("text/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");//响应数据的编码格式
        //为全局变量赋值
        methodName = request.getParameter("rqType");
        session = request.getSession();
        userService = new UserServiceImp();
        userList = userService.findByAll();
        //利用反射机制动态处理不同的请求
        try {
            method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
