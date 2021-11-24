package cn.backpackerxl.dao.impl;
/**
 * @author: backpackerxl
 * @create: 2021/10/28
 * @filename: UserDaoImpl
 **/

import cn.backpackerxl.entity.User;
import cn.backpackerxl.util.DButils;
import cn.backpackerxl.dao.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    User user = null;

    @Override
    public User findByName(String name) {
        try {
//            System.out.println(sql);
            String sql = "select * from t_user where name = ?";
            connection = DButils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setNString(1, name);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String rname = resultSet.getString(2);
                String passwd = resultSet.getString(3);
                String emails = resultSet.getString(4);
                String phone = resultSet.getString(5);
                String info = resultSet.getString(6);
                String userImg = resultSet.getString(7);
                double userMoney = resultSet.getDouble(8);
                user = new User(id, rname, passwd, emails, phone, info, userImg, userMoney);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButils.close(connection, preparedStatement, resultSet);
        }
//        System.out.println(user);
        return user;
    }

    @Override
    public int registerUser(User user) {
        int i = 0;
        try {
            String sql = "insert into t_user value(id,?,?,?,?,?,?,?)";
            connection = DButils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setNString(1, user.getName());
            preparedStatement.setNString(2, user.getPasswd());
            preparedStatement.setNString(3, user.getEmail());
            preparedStatement.setNString(4, user.getPhone());
            preparedStatement.setNString(5, user.getInfo());
            preparedStatement.setNString(6, user.getUserImg());
            preparedStatement.setDouble(7, user.getUserMoney());
            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButils.close(connection, preparedStatement);
        }
        return i;
    }

    @Override
    public String findByEmail(String email) {
        String username = null;
        try {
            String sql = "select name from t_user where email = ?";
//            System.out.println(sql);
            connection = DButils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setNString(1, email);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                username = resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButils.close(connection, preparedStatement, resultSet);
        }
//        System.out.println(user);
        return username;
    }

    @Override
    public List<User> findByAll() {
        List<User> userList = new ArrayList<>();
        try {
//            System.out.println(sql);
            connection = DButils.getConnection();
            preparedStatement = connection.prepareStatement("select * from t_user");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String rname = resultSet.getString(2);
                String passwd = resultSet.getString(3);
                String emails = resultSet.getString(4);
                String phone = resultSet.getString(5);
                String info = resultSet.getString(6);
                String userImg = resultSet.getString(7);
                double userMoney = resultSet.getDouble(8);
                user = new User(id, rname, passwd, emails, phone, info, userImg, userMoney);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButils.close(connection, preparedStatement, resultSet);
        }
//        System.out.println(user);
        return userList;
    }

    @Override
    public int UpdataUser(User user) {
        int i = 0;
        try {
            String sql = "update t_user set passwd=? where id = ?";
            connection = DButils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setNString(1, user.getPasswd());
            preparedStatement.setInt(2, user.getId());
            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButils.close(connection, preparedStatement);
        }
        return i;
    }
}
