package com.codecool.shop.datamanager;
import javax.xml.crypto.Data;
import java.sql.*;



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

    private void getQueryData(ResultSet resultSet) throws SQLException{
        while (resultSet.next()) {
            String title = resultSet.getString("title");
            double price = resultSet.getDouble("price");
            String description = resultSet.getString("description");
            String imageRoute = resultSet.getString("image_route");
            System.out.println("RESULT: " + title + " " + price + " " + description + " " + imageRoute);
        }
    }

    public void getProductByCategory() throws SQLException{
        PreparedStatement stmnt = connection.prepareStatement("SELECT * FROM inventory WHERE product_category = ?");
        stmnt.setString(1, "horror");
        ResultSet resultSet = stmnt.executeQuery();
        getQueryData(resultSet);
    }

    public void getProductByPublisher() throws SQLException{
        PreparedStatement stmnt = connection.prepareStatement("SELECT * FROM inventory WHERE publisher = ?");
        stmnt.setString(1, "máté production");
        ResultSet resultSet = stmnt.executeQuery();
        getQueryData(resultSet);
    }

    public void getBestsellers() throws SQLException{
        PreparedStatement stmnt = connection.prepareStatement("SELECT * FROM inventory WHERE bestseller = TRUE");
        ResultSet resultSet = stmnt.executeQuery();
        getQueryData(resultSet);
    }
}
