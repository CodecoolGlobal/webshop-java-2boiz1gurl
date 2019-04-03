package com.codecool.shop.dao.implementation;

import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ProductDaoMemTest {

    @Test
    public void testIsProductAdded() {
        ProductDaoMem productDaoMem = ProductDaoMem.getInstance();
        Supplier supplier = new Supplier("Animus", "description");
        ProductCategory productCategory = new ProductCategory("Fantasy", "book", "categoryDescription");
        Product product = new Product("Harry Potter", 15.2f, "USD", "description", productCategory, supplier);
        productDaoMem.add(product);
        assertEquals(1, productDaoMem.getAll().size());
    }

    @Test
    public void testIsProductFound() {
        ProductDaoMem productDaoMem = ProductDaoMem.getInstance();
        Supplier supplier = new Supplier("Animus", "description");
        ProductCategory productCategory = new ProductCategory("Fantasy", "book", "categoryDescription");
        Product product = new Product("Harry Potter", 15.2f, "USD", "description", productCategory, supplier);
        productDaoMem.add(product);
        assertEquals(product, productDaoMem.find(1));
    }

    @Test
    public void testIsProductNotFound() {
        ProductDaoMem productDaoMem = ProductDaoMem.getInstance();
        Supplier supplier = new Supplier("Animus", "description");
        ProductCategory productCategory = new ProductCategory("Fantasy", "book", "categoryDescription");
        Product product = new Product("Harry Potter", 15.2f, "USD", "description", productCategory, supplier);
        productDaoMem.add(product);
        assertNull(productDaoMem.find(2));
    }

    @Test
    public void testIsProductRemoved() {
        ProductDaoMem productDaoMem = ProductDaoMem.getInstance();
        Supplier supplier = new Supplier("Animus", "description");
        ProductCategory productCategory = new ProductCategory("Fantasy", "book", "categoryDescription");
        Product product = new Product("Harry Potter", 15.2f, "USD", "description", productCategory, supplier);
        productDaoMem.add(product);
        productDaoMem.remove(1);
        assertEquals(0, productDaoMem.getAll().size());
    }

    @Test
    public void testIsProductGetAll() {
        ProductDaoMem productDaoMem = ProductDaoMem.getInstance();
        Supplier supplier = new Supplier("Animus", "description");
        ProductCategory productCategory = new ProductCategory("Fantasy", "book", "categoryDescription");
        Product product = new Product("Harry Potter", 15.2f, "USD", "description", productCategory, supplier);
        Supplier supplier2 = new Supplier("Enimus", "description");
        ProductCategory productCategory2 = new ProductCategory("Horror", "book", "categoryDescription");
        Product product2 = new Product("Game of thrones", 13.42f, "USD", "description", productCategory2, supplier2);
        productDaoMem.add(product);
        productDaoMem.add(product2);
        assertEquals(2, productDaoMem.getAll().size());
    }

    @Test
    public void testIsProductGetBySupplier() {
        ProductDaoMem productDaoMem = ProductDaoMem.getInstance();
        Supplier supplier = new Supplier("Animus", "description");
        ProductCategory productCategory = new ProductCategory("Fantasy", "book", "categoryDescription");
        Product product = new Product("Harry Potter", 15.2f, "USD", "description", productCategory, supplier);
        productDaoMem.add(product);
        assertNotNull(productDaoMem.getBy(supplier));
    }

    @Test
    public void testIsProductGetByCategory() {
        ProductDaoMem productDaoMem = ProductDaoMem.getInstance();
        Supplier supplier = new Supplier("Animus", "description");
        ProductCategory productCategory = new ProductCategory("Fantasy", "book", "categoryDescription");
        Product product = new Product("Harry Potter", 15.2f, "USD", "description", productCategory, supplier);
        productDaoMem.add(product);
        assertNotNull(productDaoMem.getBy(productCategory));
    }
}