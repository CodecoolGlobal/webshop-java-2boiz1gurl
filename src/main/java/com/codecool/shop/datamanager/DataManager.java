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


    private DataManager(){
        try {
            connection =  DriverManager.getConnection(DATABASE, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void add(String name) throws SQLException{
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO sprints (name)" +
                    "VALUES (?)"
        );
        statement.setString(1,name);
        statement.execute();
    }

}
