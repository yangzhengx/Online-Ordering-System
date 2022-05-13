package com.fc.controller;

import com.fc.entity.Admin;
import com.fc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping( "/login")
    public String login(Admin admin, HttpServletRequest request, HttpSession session){
        boolean loginType = adminService.login(admin.getName(),admin.getPwd());

        if (loginType){
            //如果通过验证，将用户信息传到前台
            request.setAttribute("admin",admin);
            session.setAttribute("admin_session",admin);

            return "redirect:/admin/main";
        }else {
            //不对，则返回
            request.setAttribute("message","用户名密码错误");
            return "redirect:/admin/index";
        }
    }
}
