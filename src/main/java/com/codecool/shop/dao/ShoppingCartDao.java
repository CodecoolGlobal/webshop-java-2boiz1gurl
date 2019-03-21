package com.codecool.shop.dao;

import com.codecool.shop.model.Product;

import java.util.ArrayList;

public interface ShoppingCartDao {

    void addToCart(int id);
    void removeFromCart(int id);
    void sumOfPrice(float price);
}
