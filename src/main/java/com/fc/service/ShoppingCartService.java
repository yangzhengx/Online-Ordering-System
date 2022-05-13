package com.fc.service;

import com.fc.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    List<ShoppingCart> findByUserId(Integer id);
}
