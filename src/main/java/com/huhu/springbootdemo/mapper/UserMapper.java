package com.huhu.springbootdemo.mapper;


import com.huhu.springbootdemo.data.model.UserModel;

import java.util.List;

public interface UserMapper {

    List<UserModel> getAll();

    UserModel getUserByUserName(String username);
}
