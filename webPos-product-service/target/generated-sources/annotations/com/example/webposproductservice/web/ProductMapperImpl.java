package com.example.webposproductservice.web;

import com.example.webposproductservice.model.Product;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-15T11:22:18+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Collection<ProductDto> toProductsDto(Collection<Product> products) {
        if ( products == null ) {
            return null;
        }

        Collection<ProductDto> collection = new ArrayList<ProductDto>( products.size() );
        for ( Product product : products ) {
            collection.add( toProductDto( product ) );
        }

        return collection;
    }

    @Override
    public ProductDto toProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( product.getId() );
        productDto.setName( product.getName() );
        productDto.setPrice( product.getPrice() );
        productDto.setCategory( product.getCategory() );
        productDto.setImg( product.getImg() );
        productDto.setStock( product.getStock() );
        productDto.setQuantity( product.getQuantity() );

        return productDto;
    }
}
