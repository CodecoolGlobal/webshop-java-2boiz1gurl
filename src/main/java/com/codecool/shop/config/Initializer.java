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
        Supplier bloomsbury = new Supplier("Bloomsbury Publishing PLC", "Book service");
        supplierDataStore.add(bloomsbury);

        Supplier harperCollins = new Supplier("HarperCollins Publishers", "Book service");
        supplierDataStore.add(harperCollins);

        Supplier walker = new Supplier("Walker Books Ltd", "Book service");
        supplierDataStore.add(walker);

        Supplier penguin = new Supplier("Penguin Putnam Inc", "Book service");
        supplierDataStore.add(penguin);

        //setting up a new product category
        ProductCategory bestSeller = new ProductCategory("Bestseller", "Bestseller", "This is a book from the bestseller section.");
        productCategoryDataStore.add(bestSeller);

        ProductCategory gastronomy = new ProductCategory("Gastronomy", "Gastronomy", "This is a book from the gastronomy section.");
        productCategoryDataStore.add(gastronomy);

        ProductCategory scifi = new ProductCategory("SciFi", "SciFi", "This is a book from the SciFi section.");
        productCategoryDataStore.add(scifi);

        ProductCategory horror = new ProductCategory("Horror", "Horror", "This is a book from the horror section.");
        productCategoryDataStore.add(horror);

        ProductCategory history = new ProductCategory("History", "History", "This is a book from the history section.");
        productCategoryDataStore.add(history);


        //setting up products and printing it
        productDataStore.add(new Product("Wuthering Heights", 7.62f, "USD", "Emily Bronte's only novel, a work of tremendous and far-reaching influence.", bestSeller, penguin));
        productDataStore.add(new Product("Thunderhead", 10.37f, "USD", "The dark and thrilling sequel to Scythe, the New York Times sci-fi bestseller.", scifi, bloomsbury));
        productDataStore.add(new Product("All Quiet on the Western Front", 10.91f, "USD", "One by one the boys begin to fall...", bestSeller, penguin));
        productDataStore.add(new Product("Sky in the Deep", 17.89f, "USD", "A 2018 Most Anticipated Young Adult book from debut author Adrienne Young.", history, harperCollins));
        productDataStore.add(new Product("Journey to the End of the Night", 18.39f, "USD", "Journey to the End of the Night is a literary symphony of violence, cruelty and obscene nihilism.", bestSeller, walker));
        productDataStore.add(new Product("Together: Our Community Cookbook", 17.15f, "USD", "Together celebrates the power of cooking to connect us to one another.", gastronomy, penguin));
        productDataStore.add(new Product("Les Miserables", 16.24f, "USD", "Victor Hugo's tale of injustice, heroism and love.", bestSeller, bloomsbury));
        productDataStore.add(new Product("Tales from the Inner City", 26.62f, "USD", "Where can we live if not in each other's shadow?", history, penguin));
        productDataStore.add(new Product("Grow Cook Nourish", 17.98f, "USD", "Darina Allen's excellent book about kitchen garden companion in 400 recipes", gastronomy, bloomsbury));
        productDataStore.add(new Product("The complete ketogenic diet for beginners", 20.32f, "USD", "Amy Ramos' book elaborates on the ketogenic diet.", gastronomy, penguin));
        productDataStore.add(new Product("History from the dawn of civilization to the present day", 15.24f, "USD", "Adam Hart-Davis wrote this book about how our history evolved from the dawn of civilization to the present day", history, walker));
        productDataStore.add(new Product("The vikings", 10.45f, "USD", "Jonathan Clements' questions in his book that if the vikings were the last pagans or the first europeans.", history, bloomsbury));
        productDataStore.add(new Product("The story of the world", 32.32f, "USD", "Susan Wise Bauer's book is about the ancient times. This is also the revised version.", history, harperCollins));
        productDataStore.add(new Product("The Amityville horror", 32.21f, "USD", "Jay Anson highlightes that this book will scare the hell out of you for sure.", horror, penguin));
        productDataStore.add(new Product("The beauty of horror", 20.98f, "USD", "This is a gorgeous coloring book by Alan Robert.", horror, harperCollins));
        productDataStore.add(new Product("Sci Fi Collection", 20.65f, "USD", "Keith Laumer's book is about 4 really interesting stories.", scifi, penguin));
        productDataStore.add(new Product("Morbidbooks Sci Fi anthology", 10.67f, "USD", "Steven Nelson wrote this book in 2013.", scifi, walker));
    }
}
