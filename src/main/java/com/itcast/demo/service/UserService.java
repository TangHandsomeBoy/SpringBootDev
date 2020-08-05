package com.itcast.demo.service;

import com.github.pagehelper.PageInfo;
import com.itcast.demo.domain.User;

import java.util.List;

public interface UserService {
    List<User> selectUser();

    PageInfo<User> selectPageUser(int page, int size);

    User selectUserById(Integer userId);

    User selectUserByLog(String userName,String password);

    User selectUserByName(String userName);

    int updateUser(User user);

}
