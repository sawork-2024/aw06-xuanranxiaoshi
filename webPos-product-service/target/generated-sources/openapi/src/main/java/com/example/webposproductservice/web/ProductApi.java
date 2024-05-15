/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.3.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example.webposproductservice.web;

import com.example.webposproductservice.web.ErrorDto;
import com.example.webposproductservice.web.ProductDto;
import com.example.webposproductservice.web.ProductQuantityDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-15T21:04:30.192876400+08:00[Asia/Shanghai]")
@Validated
@Tag(name = "product", description = "the product API")
public interface ProductApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /product : List all products
     *
     * @return A paged array of products (status code 200)
     *         or unexpected error (status code 200)
     */
    @Operation(
        operationId = "listProducts",
        summary = "List all products",
        tags = { "product" },
        responses = {
            @ApiResponse(responseCode = "200", description = "A paged array of products", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProductDto.class)))
            }),
            @ApiResponse(responseCode = "default", description = "unexpected error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/product",
        produces = { "application/json" }
    )
    default ResponseEntity<List<ProductDto>> listProducts(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"img\" : \"img\", \"quantity\" : 6, \"price\" : \"\", \"name\" : \"name\", \"id\" : \"id\", \"category\" : \"category\", \"stock\" : 0 }, { \"img\" : \"img\", \"quantity\" : 6, \"price\" : \"\", \"name\" : \"name\", \"id\" : \"id\", \"category\" : \"category\", \"stock\" : 0 } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /product/{productId} : Info for a specific product
     *
     * @param productId The id of the product to retrieve (required)
     * @return Expected response to a valid request (status code 200)
     *         or unexpected error (status code 200)
     */
    @Operation(
        operationId = "showProductById",
        summary = "Info for a specific product",
        tags = { "product" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Expected response to a valid request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))
            }),
            @ApiResponse(responseCode = "default", description = "unexpected error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/product/{productId}",
        produces = { "application/json" }
    )
    default ResponseEntity<ProductDto> showProductById(
        @Parameter(name = "productId", description = "The id of the product to retrieve", required = true, in = ParameterIn.PATH) @PathVariable("productId") String productId
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"img\" : \"img\", \"quantity\" : 6, \"price\" : \"\", \"name\" : \"name\", \"id\" : \"id\", \"category\" : \"category\", \"stock\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PATCH /product/{productId} : Update a product
     *
     * @param productId The id of the product to update (required)
     * @param productQuantityDto Update product quantity (required)
     * @return Product update successfully. (status code 200)
     *         or unexpected error (status code 200)
     */
    @Operation(
        operationId = "updateProduct",
        summary = "Update a product",
        tags = { "product" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Product update successfully.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))
            }),
            @ApiResponse(responseCode = "default", description = "unexpected error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PATCH,
        value = "/product/{productId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<ProductDto> updateProduct(
        @Parameter(name = "productId", description = "The id of the product to update", required = true, in = ParameterIn.PATH) @PathVariable("productId") String productId,
        @Parameter(name = "ProductQuantityDto", description = "Update product quantity", required = true) @Valid @RequestBody ProductQuantityDto productQuantityDto
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"img\" : \"img\", \"quantity\" : 6, \"price\" : \"\", \"name\" : \"name\", \"id\" : \"id\", \"category\" : \"category\", \"stock\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
