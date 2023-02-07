package com.example.Product.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    public Product addProduct(Product product){

        return productRepo.save(product);

    }

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public Product findProductById(Long id){
        return productRepo.findById(id).orElseThrow(()-> new ProductNotFoundException("Product with id " + id + " not found!"));
    }
    public void  delete(Long id){
        productRepo.deleteById(id);
    }
}
