package com.fc.service.impl;

import com.fc.dao.AdminMapper;
import com.fc.entity.Admin;
import com.fc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String toLogin(){
        return "/admin/index";
    }

    //login业务的访问位置为/admin/menus
    @Override
    public boolean login(String name, String pwd) {
        Admin admin = adminMapper.queryByName(name);
        if (admin != null){
            if (admin.getName().equals(name) && admin.getPwd().equals(pwd)){
                return true;
            }
        }
        return false;
    }
}
