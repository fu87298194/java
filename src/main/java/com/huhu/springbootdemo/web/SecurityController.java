package com.huhu.springbootdemo.web;

import com.huhu.springbootdemo.data.enums.UserSexEnum;
import com.huhu.springbootdemo.data.model.UserModel;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class SecurityController {

    @GetMapping("hello")
    public String hello() {
        return "hello security";
    }

    @GetMapping(value="/index")
    public String index() {
        return "hello index";
    }

    @GetMapping("update")
    //@Secured({"ROLE_sale","ROLE_manager"})
    //@PreAuthorize("hasAnyAuthority('admins')")
    @PostAuthorize("hasAnyAuthority('admins')")
    public String update() {
        System.out.println("update......");
        return "hello update";
    }

    @GetMapping("getAll")
    @PostAuthorize("hasAnyAuthority('admins')")
    @PostFilter("filterObject.username == 'admin1'")
    public List<UserModel> getAllUser(){
        ArrayList<UserModel> list = new ArrayList<>();
        list.add(new UserModel("1","admin1","6666", UserSexEnum.MAN,"aa"));
        list.add(new UserModel("3","admin1","6666", UserSexEnum.MAN,"aa"));
        System.out.println(list);
        return list;
    }

}
