package com.example.demo4.dao;

import com.example.demo4.po.User;
import com.example.demo4.query.UserQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

@Mapper
public interface UserMapper {
    //通过用户名查询用户 返回用户对象
     User queryUserByName(String userName);

    //通过用户id查用户 返回用户对象
     User queryUserById(Integer UserId);

    //添加用户返回受影响的行数
     int addUser(User user);

    //修改用户返回受影响的行数
     int updateUser(User user);

    //删除用户返回受影响的行数
     int deleteUser(Integer userId);

    //通过指定条件查用户集合
     List<User> queryUserByparams(UserQuery userQuery);
}
