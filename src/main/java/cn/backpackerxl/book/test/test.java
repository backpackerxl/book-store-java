package cn.backpackerxl.book.test;
/**
 * @author: backpackerxl
 * @create: 2021/10/28
 * @filename: LoginServlet
 **/

import cn.backpackerxl.book.entity.User;
import cn.backpackerxl.book.service.UserService;
import cn.backpackerxl.book.service.impl.UserServiceImp;
import cn.backpackerxl.book.servlet.SendEmailServlet;
import cn.backpackerxl.book.util.DButils;
import cn.backpackerxl.book.util.StringToJSON;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class test {

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
        User user = null;
        for (User user1 : userList) {
            if ("946115360@qq.com".equals(user1.getEmail())) {
                user = user1;
            }
        }
        user.setPasswd("123456");
        int i1 = userService1.UpdataUser(user);
        if (i1 == 0) {
            System.out.println("修改失败");
        } else {
            System.out.println("修改成功");
        }
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
        if (user == null){
            return;
        }
        System.out.println(user);
    }

    @Test
    public void time() {
        System.out.println(DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM).format(new Date()));
    }

    @Test
    public void select(){
        UserService userService = new UserServiceImp();
        List<User> userList = userService.findByAll();
        userList.stream().forEach(user ->{
            if ("龙在天".equals(user.getName())) {
                System.out.println("龙在天在数据库中");
            }});
    }
}
