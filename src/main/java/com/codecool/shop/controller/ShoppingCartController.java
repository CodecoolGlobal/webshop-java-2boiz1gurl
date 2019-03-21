package com.codecool.shop.controller;


import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.ShoppingCartDao;
import com.codecool.shop.dao.implementation.ShoppingCartDaoMem;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/addtocart")
public class ShoppingCartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get parameters from request
        String productId = req.getParameter("productId");

//        // print the response
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//        out.write("<html><body>");
//        out.write("<h2>Servlet HTTP Request Parameters example</h2>");
//        out.write("<p>param1: " + productId + "</p>");

        // add product to cart
        ShoppingCartDaoMem.getInstance().addToCart(Integer.parseInt(productId));
        resp.sendRedirect("/");
    }
}