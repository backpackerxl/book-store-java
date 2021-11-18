package cn.backpackerxl.service;
/**
 * @author: backpackerxl
 * @create: 2021/10/28
 * @filename: UserService
 **/

import cn.backpackerxl.entity.User;

import java.util.List;

public interface UserService {
    User findByName(String name);

    int registerUser(User user);

    String findByEmail(String email);

    List<User> findByAll();

    int UpdataUser(User user);
}
