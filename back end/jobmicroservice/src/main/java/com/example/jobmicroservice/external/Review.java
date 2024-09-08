package com.example.jobmicroservice.external;

import jakarta.persistence.*;

@Table(name = "review_table")
public class Review {

    @Column(name = "rev_id")
    private Integer id;

    @Column(name = "rev_title")
    private String title;

    @Column(name = "rev_description")
    private String description;

    @Column(name = "rev_rating")
    private double rating;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
