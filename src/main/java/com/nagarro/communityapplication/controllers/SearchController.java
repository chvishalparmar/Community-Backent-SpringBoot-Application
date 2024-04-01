package com.nagarro.communityapplication.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.communityapplication.dto.ProductDto;
import com.nagarro.communityapplication.entities.Product;
import com.nagarro.communityapplication.repository.ProductRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/search")
public class SearchController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/byproductname/{name}")
    private ResponseEntity<?> byname(@PathVariable String name){

        if(!productRepository.existsByProductname(name)){
            return new ResponseEntity<>("Product Not Exists!", HttpStatus.BAD_REQUEST);
        }
        List<Product> product = productRepository.findByProductname(name);
       return new ResponseEntity<Object>(product,HttpStatus.OK);
    }

    @GetMapping("/byproductcode/{code}")
    private ResponseEntity<?> bycode(@PathVariable String code){

        if(!productRepository.existsByProductcode(code)){
            return new ResponseEntity<>("Product Not Exists!", HttpStatus.BAD_REQUEST);
        }
        Product product = productRepository.findByProductcode(code);
       return new ResponseEntity<Object>(product,HttpStatus.OK);
    }

    @GetMapping("/byproductbrand/{brand}")
    private ResponseEntity<?> bybrand(@PathVariable String brand){
        if(!productRepository.existsByBrand(brand)){
            return new ResponseEntity<>("Product Not Exists!", HttpStatus.BAD_REQUEST);
        }
        List<Product> product = productRepository.findByBrand(brand);
       return new ResponseEntity<Object>(product,HttpStatus.OK);
    }

    @PostMapping("/byall")
    private ResponseEntity<?> search(@RequestBody ProductDto productDto){

        //System.out.println(productDto.toString());

        if(!productRepository.existsByProductname(productDto.getProductname())){
            return new ResponseEntity<>("Product Not Exists with this Name!", HttpStatus.BAD_REQUEST);
        }else if(!productRepository.existsByProductcode(productDto.getProductcode())){
            return new ResponseEntity<>("Product Not Exists with this Code!", HttpStatus.BAD_REQUEST);
        }else if(!productRepository.existsByBrand(productDto.getBrand())){
            return new ResponseEntity<>("Product Not Exists!", HttpStatus.BAD_REQUEST);
        }else{
            Product product = productRepository.findByProductcode(productDto.getProductcode());
            return new ResponseEntity<Object>(product,HttpStatus.OK);
        }

    }

    
}
