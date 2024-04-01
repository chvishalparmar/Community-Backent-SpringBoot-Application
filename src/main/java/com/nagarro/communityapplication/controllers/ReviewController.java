package com.nagarro.communityapplication.controllers;

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

import com.nagarro.communityapplication.dto.ReviewDto;
import com.nagarro.communityapplication.entities.Product;
import com.nagarro.communityapplication.entities.Review;
import com.nagarro.communityapplication.repository.ProductRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/add/{id}")
    private ResponseEntity<?> addreview(@PathVariable String id, @RequestBody ReviewDto reviewdto ){

        if(!productRepository.existsByProductcode(id)){
            return new ResponseEntity<>("Product Not Exists!", HttpStatus.BAD_REQUEST);
        }
        Product product = productRepository.findByProductcode(id);

        Review review =new Review();
        review.setApprove(false);
        review.setData(reviewdto.getData());
        product.getReviews().add(review);

        this.productRepository.save(product);
        return new ResponseEntity<>("Review Added successfully", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    private ResponseEntity<Object> getreview(@PathVariable String id ){

        if(!productRepository.existsByProductcode(id)){
            return new ResponseEntity<>("Product Not Exists!", HttpStatus.BAD_REQUEST);
        }

        Product product = productRepository.findByProductcode(id);
        return new ResponseEntity<Object>(product,HttpStatus.OK);



    }
    
    
}
