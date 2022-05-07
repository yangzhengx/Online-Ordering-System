package com.fc.controller;

import com.fc.entity.Users;
import com.fc.service.UsersService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("login")
    public ModelAndView login(Users users,ModelAndView mv){

       ResultVO result= usersService.login(users.getName(),users.getPwd());

        if (result.getCode()==200){

            mv.setViewName("redirect:/menus/qiantai/allMenus");
            //return "redirect:/menus/qiantai/allMenus";
        }else {

            mv.addObject("resultInfo", result);
            mv.setViewName("forward:/login.jsp");
            //return "redirect:/public/qiantai/login.jsp";
        }

         return mv;
    }

//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public String login(Users users,
//                        HttpSession session,
//                        HttpServletResponse response,
//                        MenusExample menusExample,
//                        String nom) {
//        //usersService.login(users.getName(), users.getPwd(),menusExample);
//
//        ResultVO resultVO =  usersService.login(users.getName(), users.getPwd(),menusExample);
//        if (resultVO.getCode()==-1){
//            //登录失败
//            return "/qiantai";
//        }else {
//            session.setAttribute("menusList",resultVO.getData());
//            System.out.println(resultVO.getData());
//            Menus menus = new Menus();
//            System.out.println(menus);
//            Cookie cookie = new Cookie("JSESSIONID", session.getId());
//            cookie.setMaxAge(30*60);
//
//            response.addCookie(cookie);
//        }
//
//        return "/qiantai/index";
//    }
}
