package com.example.Product.product;

import java.sql.SQLOutput;

public class ProductNotFoundException extends RuntimeException
{
    public ProductNotFoundException(String message){
        super(message);
    }
}
