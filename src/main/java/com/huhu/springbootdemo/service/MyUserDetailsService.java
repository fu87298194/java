package com.huhu.springbootdemo.service;

import com.huhu.springbootdemo.data.model.UserModel;
import com.huhu.springbootdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        //调用usersMapper方法，根据用户名查询数据库
//        QueryWrapper<Users> wrapper = new QueryWrapper();
//        // where username=?
//        wrapper.eq("username",username);
//        Users users = usersMapper.selectOne(wrapper);
        UserModel  user = userMapper.getUserByUserName(username);
        //判断
        if(user == null) {//数据库没有用户名，认证失败
            throw  new UsernameNotFoundException("用户名不存在！");
        }
        List<GrantedAuthority> auths =
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_sale");
        //从查询数据库返回users对象，得到用户名和密码，返回
        return new User(user.getUserName(),
                new BCryptPasswordEncoder().encode(user.getPassWord()),auths);
    }
}
