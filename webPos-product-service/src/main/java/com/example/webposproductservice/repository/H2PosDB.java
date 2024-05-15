package com.example.webposproductservice.repository;

import com.example.webposproductservice.model.Product;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author：jimi
 * @date: 2024/4/23
 * @Copyright：
 */
@Data
@Service
public class H2PosDB implements PosDB {
    private ProductRepository productRepository;

    @Autowired
    public H2PosDB(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(String productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}