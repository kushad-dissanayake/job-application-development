package com.example.jobmicroservice.external;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

import java.util.List;
@Table(name = "company_table")
public class Company {

    @Column(name = "company_id")
    private Integer id;

    @Column(name = "company_name")
    private String name;

    @Column(name = "company_description")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

