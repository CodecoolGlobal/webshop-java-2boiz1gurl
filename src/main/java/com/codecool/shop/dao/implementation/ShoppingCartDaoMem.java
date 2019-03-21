package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ShoppingCartDao;
import com.codecool.shop.model.Product;

import java.util.ArrayList;

public class ShoppingCartDaoMem implements ShoppingCartDao {

    private ArrayList<Product> productsInShoppingCart = new ArrayList<Product>();
    private static ShoppingCartDaoMem instance = null;

    private ShoppingCartDaoMem() {
    }

    public static ShoppingCartDaoMem getInstance() {
        if (instance == null) {
            instance = new ShoppingCartDaoMem();
        }
        return instance;
    }

    @Override
    public void addToCart(int productId) {
        productsInShoppingCart.add(ProductDaoMem.getInstance().find(productId));
    }

    @Override
    public void sumOfPrice(float defaultPrice) {
        Float sumOfPrice = 0.0f;
        for (int i = 0; i < productsInShoppingCart.size(); i++) {
            sumOfPrice += productsInShoppingCart.get(i).getDefaultPrice();
        }
    }

    @Override
    public void removeFromCart(int productId) {
    }

    public ArrayList<Product> getProductsInShoppingCart() {
        return productsInShoppingCart;
    }
}



