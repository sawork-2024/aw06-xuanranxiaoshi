package com.example.webposproductservice.repository;


import com.example.webposproductservice.model.Product;

import java.util.List;

public interface PosDB {

    public List<Product> getProducts();

    public Product getProduct(String productId);

    public void saveProduct(Product product);
}
