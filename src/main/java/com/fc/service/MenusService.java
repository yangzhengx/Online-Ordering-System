package com.fc.service;

import com.fc.entity.Menus;

import java.util.List;

public interface MenusService {
    List<Menus> allMenus(Menus menus);

    List<Menus> queryAllByLimit(int offset, int limit);

    List<Menus> findAll();
}
