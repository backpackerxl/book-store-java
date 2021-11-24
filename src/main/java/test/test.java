package test;
/**
 * @author: backpackerxl
 * @create: 2021/10/28
 * @filename: LoginServlet
 **/

import cn.backpackerxl.entity.Book;
import cn.backpackerxl.entity.User;
import cn.backpackerxl.service.BookService;
import cn.backpackerxl.service.UserService;
import cn.backpackerxl.service.impl.BookUserServiceImp;
import cn.backpackerxl.service.impl.UserServiceImp;
import cn.backpackerxl.util.DButils;
import cn.backpackerxl.util.StringToJSON;
import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import static cn.backpackerxl.util.MD5Utils.code;


public class test {

    @Test
    public void updata() {
        UserService service = new UserServiceImp();
        User user = new User();
        user = service.findByName("admin");
        System.out.println(user);
        user.setPasswd("123456");
        int i = service.UpdataUser(user);
        System.out.println(i);
        if (i == 0) {
            System.out.println("修改失败");
        }
    }

    public String login() {
        return "login";
    }

    public static void main(String[] args) {
        test t = new test();
        t.login();
    }

    @Test
    public void testConon() throws SQLException {
        Connection connection = DButils.getConnection();
        System.out.println(connection);
    }

    @Test
    public void testJSON() {
        System.out.println(new StringToJSON("info", "hello").toJSON());
    }

    @Test
    public void testGetName() {
//        URL path = DButils.class.getResource("/");
//        String url = path.toString().substring(6,36);
//        String ourl = "/src/main/resources/druid.properties";
//        System.out.println(url+ourl);
//        String model = "t_user";
//        String first = model.substring(2).substring(0, 1).toUpperCase();
//        String parm = first + model.substring(3);
//        System.out.println(parm);
        UserService userService1 = new UserServiceImp();
//        User user = userService1.findByEmailAll("946115360@qq.com");
//        User user = userService1.findByName("admin");
        List<User> userList = userService1.findByAll();
//        User user = null;
//        for (User user1 : userList) {
//            if ("946115360@qq.com".equals(user1.getEmail())) {
//                user = user1;
//            }
//        }
//        user.setPasswd("123456");
//        int i1 = userService1.UpdataUser(user);
//        if (i1 == 0) {
//            System.out.println("修改失败");
//        } else {
//            System.out.println("修改成功");
//        }
//        User ruser = new User();
//        ruser.setName("root");
//        ruser.setPasswd("root");
//        ruser.setEmail("123589@qq.com");
//        ruser.setPhone("12345678921");
//        ruser.setInfo("哈哈哈");
//        int blog = userService.registerUser(ruser);
//        if (blog == 0){
//            System.out.println("注册失败");
//        }else {
//            System.out.println("注册成功");
//        }
//        if (user == null) {
//            return;
//        }
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
        }
//        String chars = "0123456789qazxswedcvfrbgtnhymjukilopQAZXSWCDERFVBGTYHNMJUIKLOP";
//        System.out.println(chars.charAt(61));
//        String mobile = "0123456789";
//        char[] rands = new char[6];
//        for (int i = 0; i < 6; i++) {
//            int rand = (int) (Math.random() * 9);
//            rands[i] = mobile.charAt(rand);
//        }
//        System.out.println(new String(rands));
    }

    @Test
    public void testGet() {
        UserService userService = new UserServiceImp();
        User user = userService.findByName("屌炸了");
        if (user == null) {
            return;
        }
        System.out.println(user);
    }

    @Test
    public void time() throws UnknownHostException {
        String address = InetAddress.getLocalHost().getHostAddress();
        System.out.println("\033[42mDONE\033[0m" + "\033[32m ,Compiled successfully\033[0m");
        System.out.println("App running at:");
        System.out.println("[\033[36m" + DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM).format(new Date()) + "\033[0m] \033[42mINFO\033[0m - Local: \033[34mhttp://localhost:3000/book-store\033[0m");
        System.out.println("[\033[36m" + DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM).format(new Date()) + "\033[0m] \033[42mINFO\033[0m - Network: \033[34mhttp://" + address + ":3000/book-store\033[0m");
        System.out.println("Note that the development build is not optimized.\nTo create a production build, run \033[36mmvn clean package\033[0m.");
    }

    @Test
    public void arr() {
        int[][] num = {{(int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)}, {(int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)}, {(int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)}, {(int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)}};
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i][0] + "\t" + num[i][1] + "\t" + num[i][2]);
        }
    }

    @Test
    public void banner() {
        String banner = " \033[36m____\033[0m                   \033[33m_\033[0m                            \033[33m _\033[0m                          \033[33m _ \033[0m\n" +
                "\033[36m| __ )    \033[0m\033[31m__ _    \033[0m\033[32m___  \033[0m\033[33m| | __  \033[0m\033[34m_ __     \033[0m\033[31m__ _    \033[0m\033[32m___  \033[0m\033[33m| | __   \033[0m\033[35m___   \033[0m\033[36m_ __  \033[0m\033[32m__  __ \033[0m\033[33m| |\033[0m\n" +
                "\033[36m|  _ \\   \033[0m\033[31m/ _` |  \033[0m\033[32m/ __| \033[0m\033[33m| |/ / \033[0m\033[34m| '_ \\   \033[0m\033[31m/ _` |  \033[0m\033[32m/ __| \033[0m\033[33m| |/ /  \033[0m\033[35m/ _ \\ \033[0m\033[36m| '__| \033[0m\033[32m\\ \\/ / \033[0m\033[33m| |\033[0m\n" +
                "\033[36m| |_) | \033[0m\033[31m| (_| | \033[0m\033[32m| (__  \033[0m\033[33m|   <  \033[0m\033[34m| |_) | \033[0m\033[31m| (_| | \033[0m\033[32m| (__  \033[0m\033[33m|   <  \033[0m\033[35m|  __/ \033[0m\033[36m| |     \033[0m\033[32m>  <  \033[0m\033[33m| |\033[0m\n" +
                "\033[36m|____/   \033[0m\033[31m\\__,_|  \033[0m\033[32m\\___| \033[0m\033[33m|_|\\_\\ \033[0m\033[34m| .__/   \033[0m\033[31m\\__,_|  \033[0m\033[32m\\___| \033[0m\033[33m|_|\\_\\  \033[0m\033[35m\\___| \033[0m\033[36m|_|    \033[0m\033[32m/_/\\_\\ \033[0m\033[33m|_|\033[0m\n" +
                "                              \033[0m\033[34m|_|\033[0m                                                   \n";

        System.out.println(banner);
    }

    @Test
    public void select() {
        UserService userService = new UserServiceImp();
        List<User> userList = userService.findByAll();
        userList.stream().forEach(user -> {
            if ("龙在天".equals(user.getName())) {
                System.out.println("龙在天在数据库中");
            }
        });
    }

    public void update(String code, int id) throws SQLException {
        String sql = "update t_book set book_code=? where id = ?";
        Connection connection = DButils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setNString(1, code);
        preparedStatement.setInt(2, id);
        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }
    @Test
    public void Url() throws SQLException {
//        InputStream in = this.getClass().getResourceAsStream("/druid.properties");
        for (int i = 49; i < 50; i++) {
            this.update(code(String.valueOf(Math.PI*Math.random())), i);
        }
    }

    @Test
    public void getBookList(){
        BookService bookService = new BookUserServiceImp();
        List<Book> bookList = bookService.recommendBook(5);
        System.out.println(bookList);
    }
}
