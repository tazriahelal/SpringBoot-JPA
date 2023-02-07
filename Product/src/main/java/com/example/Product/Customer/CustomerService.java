package com.example.Product.Customer;

import com.example.Product.product.Product;
import com.example.Product.product.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }

    public Customer addCustomer(Customer customer){

        return customerRepo.save(customer);

    }

    public List<Customer> getAllCustomer(){
        return customerRepo.findAll();
    }

    public Customer findCustomerById(Long id){
        return customerRepo.findById(id).orElseThrow(()-> new CustomerNotFoundException("Customer with id \" + id + \" not found!"));
    }
    public void  delete(Long id){
        customerRepo.deleteById(id);
    }
}
