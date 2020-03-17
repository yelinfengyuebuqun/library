package com.cjdx.library.controller;

import com.cjdx.library.service.BookService;
import com.cjdx.library.service.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserAdminController {
    @Autowired
    private UserAdminService userAdminService;
    @Autowired
    private BookService bookService;


    @RequestMapping("/adminLoginPage")
    public String adminLoginPage(){
        return "adminLogin";
    }

    @RequestMapping("/userLoginPage")
    public String userLoginPage(){
        return "index";
    }


    @RequestMapping("isAdminExist")
    @ResponseBody
    public boolean isAdminExist(String adminName){
        if (userAdminService.getAdminByName(adminName)!=null){
            return true;
        }else{
            return false;
        }

    }

    @RequestMapping("isUserExist")
    @ResponseBody
    public boolean isUserExist(String userName){
        if (userAdminService.getUserByName(userName)!=null){
            return true;
        }else{
            return false;
        }
    }

    //用户首页跳转
    @RequestMapping("/userLogin")
    public String userLogin(Model model, String userName, String password, HttpSession session){
        if (userAdminService.getUser(userName,password)!=null){
            session.setAttribute("user",userAdminService.getUser(userName,password));
            session.setMaxInactiveInterval(60*60*24);
            return "user/index";
        }else {
            model.addAttribute("msg","<script>alert('密码输入错误!')</script>");
            return "index";
        }
    }

    //管理员首页跳转
    @RequestMapping("/adminLogin")
    public String adminLogin(Model model, String adminName, String password, HttpSession session){
        if (userAdminService.getAdmin(adminName,password)!=null){
            session.setAttribute("admin",userAdminService.getAdmin(adminName,password));
            session.setMaxInactiveInterval(60*60*24);
            return "admin/index";
        }else {
            model.addAttribute("msg","<script>alert('密码输入错误!')</script>");
            return "adminLogin";
        }
    }

    //管理员退出
    @RequestMapping("/adminLogOut")
    public String adminLogOut(HttpSession session){
        session.invalidate();
        return "adminLogin";
    }


    //用户退出
    @RequestMapping("/userLogOut")
    public String userLogOut(HttpSession session){
        session.invalidate();
        return "index.html";
    }
}
