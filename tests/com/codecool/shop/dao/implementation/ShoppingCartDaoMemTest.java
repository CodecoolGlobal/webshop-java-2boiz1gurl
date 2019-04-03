package com.codecool.shop.dao.implementation;

import com.codecool.shop.model.BaseModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartDaoMemTest {
    @Test
    public void testIsProductAddedToCart() {
        ShoppingCartDaoMem shoppingCartDaoMem = ShoppingCartDaoMem.getInstance();
        BaseModel baseModel = new BaseModel("baseModel");
//        shoppingCartDaoMem.addToCart(productId);
    }
}