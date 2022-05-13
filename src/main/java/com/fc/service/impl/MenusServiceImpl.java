package com.fc.service.impl;

import com.fc.dao.MenusMapper;
import com.fc.entity.Menus;
import com.fc.service.MenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenusServiceImpl implements MenusService {
    @Autowired
    private MenusMapper menusMapper;

    //查询所有菜品信息
    @Override
    public List<Menus> allMenus(Menus menus) {
        return menusMapper.selectByExample(null);
    }


    @Override
    public List<Menus> queryAllByLimit(int offset, int limit) {
        return menusMapper.queryAllByLimit(offset,limit);
    }

    @Override
    public List<Menus> findAll() {
        return menusMapper.selectByExample(null);
    }


}
