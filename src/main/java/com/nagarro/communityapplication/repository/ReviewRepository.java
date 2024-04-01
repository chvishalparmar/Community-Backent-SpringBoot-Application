package com.nagarro.communityapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.communityapplication.entities.Review;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    
}
