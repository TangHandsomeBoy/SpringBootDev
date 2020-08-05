package com.itcast.demo.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itcast.demo.dao.UserDao;
import com.itcast.demo.domain.User;
import com.itcast.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> selectUser() {
        return userDao.selectUser();
    }



    @Override
    public PageInfo<User>  selectPageUser(int page, int size) {
        //静态分页
        PageHelper.startPage(page, size);
        //分页查询
        return new PageInfo<>(userDao.selectUser());
    }

    @Override
    public User selectUserById(Integer userId) {
        return userDao.selectUserById(userId);
    }

    @Override
    public User selectUserByLog(String userName, String password) {
        return userDao.selectUserByLog(userName,password);
    }

    @Override
    public User selectUserByName(String userName) {
        return userDao.selectUserByName(userName);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

}
