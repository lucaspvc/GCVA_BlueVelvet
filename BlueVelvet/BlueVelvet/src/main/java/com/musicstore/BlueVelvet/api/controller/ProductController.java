package com.musicstore.BlueVelvet.api.controller;

import com.musicstore.BlueVelvet.api.response.ProductResponse;
import com.musicstore.BlueVelvet.api.request.ProductRequest;
import com.musicstore.BlueVelvet.api.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@Log4j2
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    @GetMapping("/{id}")
    @Operation(summary = "Get product by id", description = "Get a product from the Blue Velvet Music Store")
    public ResponseEntity<ProductResponse> getProducts(@PathVariable Long id) {
        log.info("Request received to fetch a product by id: " + id);
        ProductResponse response = productService.getProductById(id);
        return ResponseEntity.ok(response);
    }

    //Todo: Add pageble from spring date
    @GetMapping
    @Operation(summary = "Get all products", description = "Fetch all products from the Blue Velvet Music Store")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> response = productService.getAllProducts();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete product by id", description = "Delete a product from the Blue Velvet Music Store")
    public ResponseEntity<Void> deleteProductBtId(@PathVariable long id){
        log.info("Request received to delete a product by id: " + id);

        return ResponseEntity.ofNullable(null);

    }

    @PostMapping
    @Operation(summary = "Create a new product", description = "Create a product for Blue Velvet Music Store")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest request){
        log.info("Requeste received to create a new product:" + request);

        return ResponseEntity.ok(assembleProductResponseMock(7L));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a product", description = "Update a product from the Blue Velvet Music Store")
    public ResponseEntity<ProductResponse> updateProductById(@PathVariable Long id, @RequestBody ProductRequest request){
        log.info("Request received to update the product with id {} with the request {}", id, request);
        return ResponseEntity.ok(assembleProductResponseMock(id));

    }


    //Remove
    private static ProductResponse assembleProductResponseMock(Long id) {
        return ProductResponse.builder()
                .id(id)
                .name("CD player")
                .brand("Elgin")
                .build();
    }


}
