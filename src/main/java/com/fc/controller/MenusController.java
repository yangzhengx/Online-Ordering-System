package com.fc.controller;

import com.fc.entity.Menus;
import com.fc.service.MenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("menus")
public class MenusController {
    @Autowired
    private MenusService menusService;

    //查询所有的菜单，前台用
    @RequestMapping("/qiantai/allMenus")
    public String allMenus(Menus menus, HttpSession session){
        List<Menus> menus1 = menusService.allMenus(menus);
        session.setAttribute("list",menus1);
        return "redirect:/public/qiantai/index.jsp";
    }


    //查询全部菜单，并且返回到菜单信息页面
    @RequestMapping("/qiantai")
    public String list(Model model){

        List<Menus> list =  menusService.queryAllByLimit(1,10);
        model.addAttribute("list",list);

        return "redirect:/public/qiantai/index.jsp";
    }
}
