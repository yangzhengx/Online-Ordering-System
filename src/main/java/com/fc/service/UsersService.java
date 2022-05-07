package com.fc.service;

import com.fc.vo.ResultVO;

public interface UsersService {

    //ResultVO login(String name, String pwd, MenusExample menusExample);

    ResultVO login(String name, String pwd);


}
