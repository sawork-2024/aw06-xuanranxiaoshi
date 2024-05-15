package com.example.webposproductservice.web;

import com.example.webposproductservice.model.Product;
import com.example.webposproductservice.web.ProductDto;
import org.mapstruct.Mapper;

import java.util.Collection;

/**
 * @description:
 * @author：jimi
 * @date: 2024/4/20
 * @Copyright：
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {
    Collection<ProductDto> toProductsDto(Collection<Product> products);

    ProductDto toProductDto(Product product);
}

