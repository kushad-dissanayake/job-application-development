package com.example.jobmicroservice.clients;

import com.example.jobmicroservice.external.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COMPANY-SERVICE")
public interface CompanyClient {
    @GetMapping("/companies/{id}")
    Company getCompany(@PathVariable("id") Integer id);
}
