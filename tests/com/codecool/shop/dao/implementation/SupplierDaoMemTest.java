package com.codecool.shop.dao.implementation;

import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SupplierDaoMemTest {

    @Test
    public void testIsSupplierAdded() {
        SupplierDaoMem supplierDaoMem = SupplierDaoMem.getInstance();
        Supplier supplier = new Supplier("Animus", "description");
        supplierDaoMem.add(supplier);
        assertEquals(1, supplierDaoMem.getAll().size());
    }

    @Test
    public void testIsSupplierFound() {
        SupplierDaoMem supplierDaoMem = SupplierDaoMem.getInstance();
        Supplier supplier = new Supplier("Animus", "description");
        supplierDaoMem.add(supplier);
        assertEquals(supplier, supplierDaoMem.find(1));
    }

    @Test
    public void testIsSupplierNotFound() {
        SupplierDaoMem supplierDaoMem = SupplierDaoMem.getInstance();
        Supplier supplier = new Supplier("Animus", "description");
        supplierDaoMem.add(supplier);
        assertNull(supplierDaoMem.find(3));
    }

    @Test
    public void testIsSupplierRemoved() {
        SupplierDaoMem supplierDaoMem = SupplierDaoMem.getInstance();
        Supplier supplier = new Supplier("Animus", "description");
        supplierDaoMem.add(supplier);
        supplierDaoMem.remove(1);
        assertEquals(0, supplierDaoMem.getAll().size());
    }

    @Test
    public void testIsSupplierGetAll() {
        SupplierDaoMem supplierDaoMem = SupplierDaoMem.getInstance();
        Supplier supplier = new Supplier("Animus", "description");
        Supplier supplier2 = new Supplier("Enimus", "description");
        supplierDaoMem.add(supplier);
        supplierDaoMem.add(supplier2);
        assertEquals(2, supplierDaoMem.getAll().size());
    }
}