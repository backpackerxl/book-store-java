package cn.backpackerxl.service.impl;
/**
 * @author: backpackerxl
 * @create: 2021/10/28
 * @filename: UserServiceImp
 **/

import cn.backpackerxl.dao.UserDao;
import cn.backpackerxl.dao.impl.UserDaoImpl;
import cn.backpackerxl.entity.User;
import cn.backpackerxl.service.UserService;

import java.util.List;

public class UserServiceImp implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public int registerUser(User user) {
        return userDao.registerUser(user);
    }

    @Override
    public String findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public List<User> findByAll() {
        return userDao.findByAll();
    }

    @Override
    public int UpdataUser(User user) {
        return userDao.UpdataUser(user);
    }

}
