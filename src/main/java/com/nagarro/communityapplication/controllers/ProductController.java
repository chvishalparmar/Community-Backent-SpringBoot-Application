package com.nagarro.communityapplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.communityapplication.dto.ProductDto;
import com.nagarro.communityapplication.entities.Product;
import com.nagarro.communityapplication.repository.ProductRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    
    @PostMapping("/add")
    private ResponseEntity<?> add(@RequestBody ProductDto productDto){

        
       // add check for product exists in a DB
       if(productRepository.existsByProductcode(productDto.getProductcode())){
        return new ResponseEntity<>("Product Already Exists!", HttpStatus.BAD_REQUEST);
        }
        Product product = new Product();
        product.setProductcode(productDto.getProductcode());
        product.setProductname(productDto.getProductname());
        product.setBrand(productDto.getBrand());

        productRepository.save(product);

         return new ResponseEntity<>("Product Added successfully", HttpStatus.OK);

    }

    @GetMapping("/getproducts")
    private ResponseEntity<?> get(){
        List<Product> product = productRepository.findAll();
        return new ResponseEntity<Object>(product,HttpStatus.OK);

    }
}
