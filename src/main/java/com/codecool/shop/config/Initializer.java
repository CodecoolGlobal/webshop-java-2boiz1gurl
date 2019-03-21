package com.codecool.shop.config;

import com.codecool.shop.dao.*;
import com.codecool.shop.dao.implementation.*;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        //setting up a new supplier
        Supplier amazon = new Supplier("Amazon", "Digital content and services");
        supplierDataStore.add(amazon);
        Supplier lenovo = new Supplier("Lenovo", "Computers");
        supplierDataStore.add(lenovo);

        //setting up a new product category
        ProductCategory tablet = new ProductCategory("Best Sellers", "Book", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        productCategoryDataStore.add(tablet);

        //setting up products and printing it
        productDataStore.add(new Product("Wuthering Heights", 7.62f, "USD", "Emily Bronte's only novel, a work of tremendous and far-reaching influence.", tablet, amazon));
        productDataStore.add(new Product("Thunderhead", 10.37f, "USD", "The dark and thrilling sequel to Scythe, the New York Times sci-fi bestseller.", tablet, lenovo));
        productDataStore.add(new Product("All Quiet on the Western Front", 10.02f, "USD", "One by one the boys begin to fall...", tablet, amazon));
        productDataStore.add(new Product("Sky in the Deep", 17.89f, "USD", "A 2018 Most Anticipated Young Adult book from debut author Adrienne Young.", tablet, amazon));
        productDataStore.add(new Product("Journey to the End of the Night", 18.39f, "USD", "Journey to the End of the Night is a literary symphony of violence, cruelty and obscene nihilism.", tablet, amazon));
        productDataStore.add(new Product("Together: Our Community Cookbook", 17.15f, "USD", "Together celebrates the power of cooking to connect us to one another.", tablet, amazon));
        productDataStore.add(new Product("Les Miserables", 16.24f, "USD", "Victor Hugo's tale of injustice, heroism and love.", tablet, amazon));
        productDataStore.add(new Product("Tales from the Inner City", 26.62f, "USD", "Where can we live if not in each other's shadow?", tablet, amazon));

    }
}
