package com.huhu.springbootdemo.service;


import com.huhu.springbootdemo.data.model.UserModel;
import com.huhu.springbootdemo.data.form.UserForm;

import java.util.List;

public interface UserService {

    List<UserModel> getAll(UserForm userForm);

}
