package com.example.Product.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    //The HttpStatus.OK indicates that the request was successful and the response body contains the expected information.
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
        Product newProduct = productService.findProductById(id);
        return new ResponseEntity<>(newProduct, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        Product updatedProduct = productService.findProductById(id);
        updatedProduct.setName(product.getName());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setDescription(product.getDescription());
        updatedProduct.setImageUrl(product.getImageUrl());
        productService.addProduct(updatedProduct);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
