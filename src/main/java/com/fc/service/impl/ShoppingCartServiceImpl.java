package com.fc.service.impl;

import com.fc.dao.ShoppingCartDao;
import com.fc.entity.ShoppingCart;
import com.fc.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @Override
    public List<ShoppingCart> findByUserId(Integer id) {
        return shoppingCartDao.findByUserId(id);
    }
}
