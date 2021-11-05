package cn.backpackerxl.book.dao;
/**
 * @author: backpackerxl
 * @create: 2021/10/28
 * @filename: UserDao
 **/

import cn.backpackerxl.book.entity.User;

import java.util.List;

public interface UserDao {
    User findByName(String name);

    int registerUser(User user);

    String findByEmail(String email);

    List<User> findByAll();

    int UpdataUser(User user);
}
