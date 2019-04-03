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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductDao productDataStore = ProductDaoDB.getInstance();

        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoDB.getInstance();

        SupplierDao supplierDataStore = SupplierDaoDB.getInstance();

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

                if (req.getParameter("categories").equals("Bestseller")) {
                    context.setVariable("products", productDataStore.getBy(productCategoryDataStore.find(1)));

                } else if (req.getParameter("categories").equals("Gastronomy")) {
                    context.setVariable("products", productDataStore.getBy(productCategoryDataStore.find(2)));

                } else if (req.getParameter("categories").equals("SciFi")) {
                    context.setVariable("products", productDataStore.getBy(productCategoryDataStore.find(3)));

                } else if (req.getParameter("categories").equals("Horror")) {
                    context.setVariable("products", productDataStore.getBy(productCategoryDataStore.find(4)));

                } else if (req.getParameter("categories").equals("History")) {
                    context.setVariable("products", productDataStore.getBy(productCategoryDataStore.find(5)));
                }


            } else if (req.getParameterNames().nextElement().equals("publishers")) {

                    if (req.getParameter("publishers").equals("Bloomsbury Publishing PLC")) {
                        context.setVariable("products", productDataStore.getBy(supplierDataStore.find(1)));

                    } else if (req.getParameter("publishers").equals("HarperCollins Publishers")) {
                        context.setVariable("products", productDataStore.getBy(supplierDataStore.find(2)));

                    } else if (req.getParameter("publishers").equals("Walker Books Ltd")) {
                        context.setVariable("products", productDataStore.getBy(supplierDataStore.find(3)));

                    } else if (req.getParameter("publishers").equals("Penguin Putnam Inc")) {
                        context.setVariable("products", productDataStore.getBy(supplierDataStore.find(4)));
                    }
            }
            engine.process("product/index.html", context, resp.getWriter());
    }
}
