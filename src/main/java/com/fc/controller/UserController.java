package com.fc.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author
 *
 * 用户模块
 */
@RestController
@RequestMapping("user")
public class UserController {
    @PostMapping
    public Map<String,Object> login(String username,
                                    String password){
        HashMap<String, Object> map = new HashMap<>();

        return map;

    }
}
