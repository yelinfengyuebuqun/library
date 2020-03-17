package com.cjdx.library.service.serviceImpl;

import com.cjdx.library.entity.Admin;
import com.cjdx.library.entity.User;
import com.cjdx.library.mapper.UserAdminMapper;
import com.cjdx.library.service.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAdminServiceImpl implements UserAdminService{
    @Autowired
    private UserAdminMapper userAdminMapper;

    @Override
    public Admin getAdminByName(String adminName) {
        return userAdminMapper.getAdminByName(adminName);
    }

    @Override
    public User getUserByName(String userName) {
        return userAdminMapper.getUserByName(userName);
    }

    @Override
    public User getUser(String userName, String userPwd) {
        return userAdminMapper.getUser(userName,userPwd);
    }

    @Override
    public Admin getAdmin(String adminName, String adminPwd) {
        return userAdminMapper.getAdmin(adminName,adminPwd);
    }


}
