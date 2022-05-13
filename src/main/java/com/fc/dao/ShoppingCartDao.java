package com.fc.dao;

import com.fc.entity.ShoppingCart;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartDao {
    List<ShoppingCart> findByUserId(Integer id);
}
