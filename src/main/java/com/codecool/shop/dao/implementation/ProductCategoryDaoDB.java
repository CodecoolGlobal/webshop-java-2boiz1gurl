package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.datamanager.DataManager;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryDaoDB implements ProductCategoryDao {

    private List<ProductCategory> data = new ArrayList<>();
    private static ProductCategoryDaoDB instance = null;
    private DataManager db = DataManager.getInstance();

    private ProductCategoryDaoDB(){}

    public static ProductCategoryDaoDB getInstance(){
        if(instance == null){
            instance = new ProductCategoryDaoDB();
        }
        return instance;
    }

    @Override
    public void add(ProductCategory category) {
        category.setId(data.size() + 1);
        data.add(category);
    }

    @Override
    public ProductCategory find(int id) {
        return data.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        data.remove(find(id));
    }

    @Override
    public List<ProductCategory> getAll() {
        try{
            ResultSet result = db.getAllRecords("product_category");
            while(result.next()){
                String name = result.getString("name");
                String department = result.getString("department");
                String description = result.getString("description");
                ProductCategory productCategory = new ProductCategory(name, department, description);
                data.add(productCategory);
            }
            return data;
        } catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
}
