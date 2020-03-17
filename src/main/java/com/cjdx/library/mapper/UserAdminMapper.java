package com.cjdx.library.mapper;

import com.cjdx.library.entity.Admin;
import com.cjdx.library.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserAdminMapper {
    //根据管理员姓名查找管理员
    @Select("SELECT*FROM admin where adminName=#{adminName}")
    public Admin getAdminByName(String adminName);

    //根据用户姓名查找用户
    @Select("SELECT * FROM `user` where userName=#{userName}")
    public User getUserByName(String userName);


    //根据姓名密码查找用户
    @Select("SELECT * FROM `user` where userName=#{param1} and userPwd=#{param2}")
    public User getUser(String userName,String userPwd);
    //根据姓名密码查找管理员
    @Select("SELECT*FROM admin where adminName=#{param1} and adminPwd=#{param2}")
    public Admin getAdmin(String adminName,String adminPwd);


}
