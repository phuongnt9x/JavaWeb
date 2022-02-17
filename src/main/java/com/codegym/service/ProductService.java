package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "samsung", "sam sung ss", 6.20f));
        products.put(2, new Product(2, "iphone", "iphone ss", 60003f));
        products.put(3, new Product(3, "gloviads ", "computer", 9999.6f));
        products.put(4, new Product(4, "Adam", "computer", 92999f));
        products.put(5, new Product(5, "Sophia", "scomputer", 9999f));
        products.put(6, new Product(6, "Rose", "computer.vn", 12348f));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product findByName(String name) {
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            if(name.equals(entry.getValue().getName())){
                return entry.getValue();
            }
        }
        return null;
    }


}
