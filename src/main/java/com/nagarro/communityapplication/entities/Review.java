package com.nagarro.communityapplication.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reviewid;
    private boolean approve;
    @Column(length=1000)
    private String data;
    public long getReviewid() {
        return reviewid;
    }
    public void setReviewid(long reviewid) {
        this.reviewid = reviewid;
    }
    public boolean isApprove() {
        return approve;
    }
    public void setApprove(boolean approve) {
        this.approve = approve;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

}
