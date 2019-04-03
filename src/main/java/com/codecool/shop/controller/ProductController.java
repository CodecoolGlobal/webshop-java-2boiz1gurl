package com.codecool.shop.controller;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.*;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.datamanager.DataManager;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/"}, loadOnStartup = 1)
public class ProductController extends HttpServlet {

    private ProductDao productDataStore = ProductDaoMem.getInstance();
    private ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
    private SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DataManager db = DataManager.getInstance();
        try {
            db.getProductByCategory();
            db.getProductByPublisher();
        } catch(SQLException exception){
            System.out.println(exception);
        }


        ProductDao productDataStore = ProductDaoMem.getInstance();

        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();

        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

//        Map params = new HashMap<>();
//        params.put("category", productCategoryDataStore.find(1));
//        params.put("products", productDataStore.getBy(productCategoryDataStore.find(1)));

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
//          context.setVariables(params);
        context.setVariable("recipient", "World");
        context.setVariable("categories", productCategoryDataStore.getAll());
        context.setVariable("products", productDataStore.getAll());
        context.setVariable("publishers", supplierDataStore.getAll());

            if (!req.getParameterNames().hasMoreElements() || req.getParameterValues(req.getParameterNames().nextElement())[0].equals("All")) {
                context.setVariable("products", productDataStore.getAll());
            } else if (req.getParameterNames().nextElement().equals("categories")) {

            filterByCategory(req, context);

        } else if (req.getParameterNames().nextElement().equals("publishers")) {

            filterByPublisher(req, context);

        }
        engine.process("product/index.html", context, resp.getWriter());
    }

    private void filterByCategory(HttpServletRequest req, WebContext context) {
        int index = 0;
        String category = req.getParameter("categories");
        switch (category){
            case "Bestseller":
                index = 1;
                break;
            case "Gastronomy":
                index = 2;
                break;
            case "SciFi":
                index = 3;
                break;
            case "Horror":
                index = 4;
                break;
            case "History":
                index = 5;
                break;
        }
        context.setVariable("products", productDataStore.getBy(productCategoryDataStore.find(index)));
    }

    private void filterByPublisher(HttpServletRequest req, WebContext context) {

        int index = 0;
        String publisher = req.getParameter("publishers");
        switch (publisher){
            case "Bloomsbury Publishing PLC":
                index = 1;
                break;
            case "HarperCollins Publishers":
                index = 2;
                break;
            case "Walker Books Ltd":
                index = 3;
                break;
            case "Penguin Putnam Inc":
                index = 4;
                break;
        }
        context.setVariable("products", productDataStore.getBy(supplierDataStore.find(index)));
    }
}