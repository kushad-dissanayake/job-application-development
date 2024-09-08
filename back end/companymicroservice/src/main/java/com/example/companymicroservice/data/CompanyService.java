package com.example.companymicroservice.data;

import com.example.companymicroservice.data.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompany(Company company, Integer id);

    void createCompany(Company company);

    boolean deleteCompanyById(Integer id);

    Company getCompanyById(Integer id);
}
