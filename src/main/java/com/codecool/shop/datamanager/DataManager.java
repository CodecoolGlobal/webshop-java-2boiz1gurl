package com.codecool.shop.datamanager;
import com.codecool.shop.model.Product;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.HashMap;


public class DataManager {

    private static DataManager instance;
    private final String DATABASE = "jdbc:postgresql://localhost:5432/" + System.getenv("PSQL_DB");
    private final String DB_USER = System.getenv("PSQL_USER");
    private final String DB_PASSWORD = System.getenv("PSQL_PASSWORD");
    private Connection connection;


    public static DataManager getInstance(){
        if(instance == null) instance = new DataManager();
        return instance;
    }

    private DataManager() {
        try {
            connection = DriverManager.getConnection(DATABASE, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private HashMap getQueryData(ResultSet resultSet) throws SQLException{
        HashMap<String, Product> productsData = new HashMap<>();
        while (resultSet.next()) {
            String title = resultSet.getString("title");
            float price = resultSet.getFloat("price");
            String currency = resultSet.getString("currency");
            String description = resultSet.getString("description");
            String imageRoute = resultSet.getString("image_route");
            Product product = new Product(title, price, currency, description, imageRoute);
            productsData.put("product" + productsData.size(), product);
        }
        return productsData;
    }

//    public void getProductByCategory(String category) throws SQLException{
//        PreparedStatement stmnt = connection.prepareStatement("SELECT * FROM inventory WHERE product_category = ?");
//        stmnt.setString(1, category);
//        ResultSet resultSet = stmnt.executeQuery();
//        getQueryData(resultSet);
//    }
//
//    public void getProductByPublisher(String publisher) throws SQLException{
//        PreparedStatement stmnt = connection.prepareStatement("SELECT * FROM inventory WHERE publisher = ?");
//        stmnt.setString(1, publisher);
//        ResultSet resultSet = stmnt.executeQuery();
//        getQueryData(resultSet);
//    }
//
//    public void getBestsellers() throws SQLException{
//        PreparedStatement stmnt = connection.prepareStatement("SELECT * FROM inventory WHERE bestseller = TRUE");
//        ResultSet resultSet = stmnt.executeQuery();
//        getQueryData(resultSet);
//    }

    public ResultSet getAllRecords(String tableName) throws SQLException {
        String sql = "SELECT * FROM " + tableName;
        ResultSet resultSet = null;

        try {
            PreparedStatement stmnt = connection.prepareStatement(sql);
            resultSet = stmnt.executeQuery();
        } catch (SQLException exception) {
            System.out.println(exception + " occured!");
        }

        return resultSet;
    }
}
