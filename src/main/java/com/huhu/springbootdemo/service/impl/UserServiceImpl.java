package com.huhu.springbootdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.huhu.springbootdemo.mapper.UserMapper;
import com.huhu.springbootdemo.data.model.UserModel;
import com.huhu.springbootdemo.service.UserService;
import com.huhu.springbootdemo.data.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserModel> getAll(UserForm userForm) {

        PageHelper.startPage(userForm.getPage(), userForm.getRows());
        return userMapper.getAll();
    }
}
