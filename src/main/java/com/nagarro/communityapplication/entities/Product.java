package com.nagarro.communityapplication.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "productdetails")
public class Product {
    
    @Id
    private String productcode;
    private String productname;
    private String brand;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pc_fid", referencedColumnName = "productcode")
    List <Review> reviews = new ArrayList <> ();


    public String getProductcode() {
        return productcode;
    }


    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }


    public String getProductname() {
        return productname;
    }


    public void setProductname(String productname) {
        this.productname = productname;
    }


    public String getBrand() {
        return brand;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }

 public List<Review> getReviews() {
        return reviews;
    }


    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }


    @Override
    public String toString() {
        return "Product [productcode=" + productcode + ", productname=" + productname + ", brand=" + brand
                + ", reviews=" + reviews + "]";
    }
  


}
