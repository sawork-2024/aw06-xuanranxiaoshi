package com.example.webposproductservice.web;

import com.example.webposproductservice.model.Product;
import com.example.webposproductservice.repository.PosDB;
import com.example.webposproductservice.web.ProductDto;
import com.example.webposproductservice.web.ProductQuantityDto;
import com.example.webposproductservice.web.ProductApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:  Product Resource：管理 Product 资源，提供相关的服务
 * @author：jimi
 * @date: 2024/4/20
 * @Copyright：
 */
@Controller
public class ProductResource implements ProductApi {

    private final PosDB posDB;

    private final ProductMapper productMapper;

    @Autowired
    public ProductResource(@Qualifier("h2PosDB") PosDB posDB, ProductMapper productMapper){
        this.posDB = posDB;
        this.productMapper = productMapper;
    }

    @Override
    public ResponseEntity<List<ProductDto>> listProducts() {
        List<ProductDto> products = new ArrayList<>(productMapper.toProductsDto(this.posDB.getProducts()));
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDto> showProductById(String productId) {
        Product product = this.posDB.getProduct(productId);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productMapper.toProductDto(product), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDto> updateProduct(String productId, ProductQuantityDto productQuantityDto) {
        Product product = this.posDB.getProduct(productId);
        if(product == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        product.setQuantity(productQuantityDto.getQuantity());
        this.posDB.saveProduct(product);
        return new ResponseEntity<>(productMapper.toProductDto(product), HttpStatus.OK);
    }
}
