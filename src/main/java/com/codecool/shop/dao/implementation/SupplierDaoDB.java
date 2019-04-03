package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.datamanager.DataManager;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDaoDB implements SupplierDao {

    private List<Supplier> data = new ArrayList<>();
    private static SupplierDaoDB instance = null;
    private DataManager db = DataManager.getInstance();

    private SupplierDaoDB(){
    }

    public static SupplierDaoDB getInstance(){
        if(instance == null){
            instance = new SupplierDaoDB();
        }
        return instance;
    }

    @Override
    public void add(Supplier supplier) {
        supplier.setId(data.size() + 1);
        data.add(supplier);
    }

    @Override
    public Supplier find(int id) {
        return data.stream().filter(t -> t.getId()==id).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        data.remove(find(id));
    }

    @Override
    public List<Supplier> getAll() {
        try{
            ResultSet result = db.getAllRecords("publisher");
            while(result.next()){
                String name = result.getString("name");
                String description = result.getString("description");
                Supplier supplier = new Supplier(name, description);
                data.add(supplier);
            }
            return data;
        } catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
}
