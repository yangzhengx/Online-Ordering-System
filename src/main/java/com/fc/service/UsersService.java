package com.fc.service;

import com.fc.entity.Users;
import com.fc.vo.ResultVO;

public interface UsersService {

    ResultVO login(String name, String pwd);


    int insert(Users users);

    Users update(Users user);

    Users queryById(Integer id);
}
