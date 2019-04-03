package com.codecool.shop.dao.implementation;

import com.codecool.shop.model.BaseModel;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartDaoMemTest {

    @Test
    public void testIsProductAddedToCart() {
        ShoppingCartDaoMem shoppingCartDaoMem = ShoppingCartDaoMem.getInstance();
        shoppingCartDaoMem.addToCart(3);
        assertEquals(1, shoppingCartDaoMem.getProductsInShoppingCart().size());
    }

    @Test
    public void testGetSumOfPrice() {
//        ShoppingCartDaoMem shoppingCartDaoMem = ShoppingCartDaoMem.getInstance();
//        Supplier supplier = new Supplier("Animus", "description");
//        ProductCategory productCategory = new ProductCategory("Fantasy", "book", "categoryDescription");
//        Product product = new Product("Thunderhead", 10.37f, "USD", "The dark and thrilling", productCategory, supplier);
//        shoppingCartDaoMem.addToCart(1);
//        shoppingCartDaoMem.addToCart(2);
//        assertEquals(21.28f, shoppingCartDaoMem.getSumOfPrice());
    }
}