package com.fc.controller;

import com.fc.entity.Menus;
import com.fc.entity.ShoppingCart;
import com.fc.entity.Users;
import com.fc.service.MenusService;
import com.fc.service.ShoppingCartService;
import com.fc.service.UsersService;
import com.fc.vo.ResultVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("users")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private MenusService menusService;

    @RequestMapping("queryById")
    public Users queryById(Integer id){
        return usersService.queryById(id);
    }


    @PostMapping("login")
    public ModelAndView login(Users users,ModelAndView mv, HttpSession session){

       ResultVO result= usersService.login(users.getName(),users.getPwd());

        if (result.getCode()==200){
            Users user = (Users) result.getData();

            List<Menus> menusList = menusService.findAll();

            List<ShoppingCart> carts = shoppingCartService.findByUserId(user.getId());

            System.out.println("购物车：" + carts);

            session.setAttribute("shoppingcar", carts);
            mv.addObject("menusList", menusList);
//            mv.setViewName("redirect:/menus/qiantai/allMenus");
            mv.setViewName("forward:/public/qiantai/index.jsp");
        }else {
            mv.addObject("resultInfo", result);
            mv.setViewName("redirect:/login.jsp");

        }

         return mv;
    }


    @GetMapping("logout")
    public ModelAndView logout(ModelAndView mv, HttpSession session, HttpServletResponse response){

        session.invalidate();
        Cookie cookie = new Cookie("JSESSIONID", null);

        cookie.setMaxAge(0);

        mv.setViewName("redirect:/public/qiantai/login.jsp");
        return mv;
    }


@RequestMapping("insert")
public String insert(@Param("name") String name, @Param("pwd") String pwd, @Param("realname") String realname, @Param("sex") String sex, @Param("age") Integer age, @Param("card") String card, @Param("address") String address, @Param("Phone") String phone, @Param("email")String email, @Param("code")String code, @Param("type")Integer type){
    Users user=new Users(name,pwd,realname,sex,age,card,address,phone,email,code,type);
    usersService.insert(user);
        return "redirect:/public/qiantai/login.jsp";
    }


    @RequestMapping("update")
    public String update(HttpSession session,@Param("id") Integer id,@Param("name") String name,@Param("pwd") String pwd,@Param("realname") String realname,@Param("sex") String sex,@Param("age") Integer age,@Param("card") String card,@Param("address") String address,@Param("Phone") String phone,@Param("email")String email,@Param("code")String code,@Param("type")Integer type) {
        Users user = new Users(id, name, pwd, realname, sex, age, card, address, phone, email, code, type);

        usersService.update(user);

        session.removeAttribute("user_session");

        return "redirect:/user/login";
    }
}
