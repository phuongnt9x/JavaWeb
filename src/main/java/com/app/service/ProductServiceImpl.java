package com.app.service;

import com.app.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone 6", "iphone", 60));
        products.put(2, new Product(1, "Iphone 7", "iphone", 70));
        products.put(3, new Product(1, "Iphone 8", "iphone", 80));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product Product) {
        products.put(Product.getId(), Product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product Product) {
        products.put(id, Product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
