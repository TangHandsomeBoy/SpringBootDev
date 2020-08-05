package com.itcast.demo.dao;

import com.itcast.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserDao {

    List<User> selectUser();

    @Select("select * from tab_user where userId=#{userId}")
    User selectUserById(@Param("userId") Integer userId);

    @Select("select * from tab_user where userName=#{userName} and password=#{password}")
    User selectUserByLog(@Param("userName")String userName,@Param("password")String password);

    @Select("select * from tab_user where userName=#{userName}")
    User selectUserByName(@Param("userName")String userName);

    @Update("update tab_user set userName=#{user.userName},sex=#{user.sex},phone=#{user.phone},address=#{user.address} where userId=#{user.userId}")
    int updateUser(@Param("user") User user);
}
