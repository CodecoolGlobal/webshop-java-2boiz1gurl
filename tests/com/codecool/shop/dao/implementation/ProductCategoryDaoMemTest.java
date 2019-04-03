package com.codecool.shop.dao.implementation;

import com.codecool.shop.model.ProductCategory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductCategoryDaoMemTest {

    @Test
    public void testIsCategorytAdded() {
        ProductCategoryDaoMem productCategoryDaoMem = ProductCategoryDaoMem.getInstance();
        ProductCategory category = new ProductCategory("Fantasy", "book", "categoryDescription");
        productCategoryDaoMem.add(category);
        assertEquals(1, productCategoryDaoMem.getAll().size());
    }

    @Test
    public void testIsCategoryFound() {
        ProductCategoryDaoMem productCategoryDaoMem = ProductCategoryDaoMem.getInstance();
        ProductCategory category = new ProductCategory("Fantasy", "book", "categoryDescription");
        productCategoryDaoMem.add(category);
        assertEquals(category, productCategoryDaoMem.find(1));
    }

    @Test
    public void testIsCategoryNotFound() {
        ProductCategoryDaoMem productCategoryDaoMem = ProductCategoryDaoMem.getInstance();
        ProductCategory category = new ProductCategory("Fantasy", "book", "categoryDescription");
        productCategoryDaoMem.add(category);
        assertNull(productCategoryDaoMem.find(0));
    }

    @Test
    public void testIsCategoryRemoved() {
        ProductCategoryDaoMem productCategoryDaoMem = ProductCategoryDaoMem.getInstance();
        ProductCategory category = new ProductCategory("Fantasy", "book", "categoryDescription");
        productCategoryDaoMem.add(category);
        productCategoryDaoMem.remove(1);
        assertEquals(0, productCategoryDaoMem.getAll().size());
    }

    @Test
    public void testIsCategoryGetAll() {
        ProductCategoryDaoMem productCategoryDaoMem = ProductCategoryDaoMem.getInstance();
        ProductCategory productCategory = new ProductCategory("Fantasy", "book", "categoryDescription");
        ProductCategory productCategory2 = new ProductCategory("Horror", "book", "categoryDescription");
        productCategoryDaoMem.add(productCategory);
        productCategoryDaoMem.add(productCategory2);
        assertEquals(2, productCategoryDaoMem.getAll().size());
    }
}

