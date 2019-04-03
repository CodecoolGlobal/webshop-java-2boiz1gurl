package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.datamanager.DataManager;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDaoDB implements ProductDao {

    private List<Product> data = new ArrayList<>();
    private static ProductDaoDB instance = null;
    private DataManager db = DataManager.getInstance();

    private ProductDaoDB(){}

    public static ProductDaoDB getInstance(){
        if(instance == null){
            instance = new ProductDaoDB();
        }
        return instance;
    }

    @Override
    public void add(Product product) {
        product.setId(data.size() + 1);
        data.add(product);
    }

    @Override
    public Product find(int id) {
        return data.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        data.remove(find(id));
    }

    @Override
    public List<Product> getAll() {
        try{
            ResultSet result = db.getAllRecords("product");
            while(result.next()){
                String name = result.getString("name");
                double price = result.getDouble("price");
                String description = result.getString("description");
                String imageRoute = result.getString("image_route");
                String currency = result.getString("currency");
                Product product = new Product(name, (float) price, currency, description, imageRoute);
                data.add(product);
            }
            return data;
        } catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Product> getBy(Supplier supplier) {
        return data.stream().filter(t -> t.getSupplier().equals(supplier)).collect(Collectors.toList());
    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        return data.stream().filter(t -> t.getProductCategory().equals(productCategory)).collect(Collectors.toList());
    }
}
