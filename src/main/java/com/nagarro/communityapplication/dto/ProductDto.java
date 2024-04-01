package com.nagarro.communityapplication.dto;

public class ProductDto {
    private String productcode;
    private String productname;
    private String brand;
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
    @Override
    public String toString() {
        return "ProductDto [productcode=" + productcode + ", productname=" + productname + ", brand=" + brand + "]";
    }

    
    
}
