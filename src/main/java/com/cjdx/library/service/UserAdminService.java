package com.cjdx.library.service;

import com.cjdx.library.entity.Admin;
import com.cjdx.library.entity.User;

import java.util.List;

public interface UserAdminService {
    //根据管理员姓名查找管理员
    public Admin getAdminByName(String adminName);

    //根据用户姓名查找用户
    public User getUserByName(String userName);

    //根据姓名密码查找用户
    public User getUser(String userName,String userPwd);
    //根据姓名密码查找管理员
    public Admin getAdmin(String adminName,String adminPwd);


}
