package com.example.reviewmicroservice.data;

import jakarta.persistence.*;

@Entity
@Table(name = "review_table")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "rev_id")
    private Integer id;

    @Column(name = "rev_title")
    private String title;

    @Column(name = "rev_description")
    private String description;

    @Column(name = "rev_rating")
    private double rating;

    @Column(name = "company_id")
    private Integer companyId;

    public Review() {
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

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
