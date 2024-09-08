package com.example.jobmicroservice.service;

import com.example.jobmicroservice.clients.CompanyClient;
import com.example.jobmicroservice.clients.ReviewClient;
import com.example.jobmicroservice.data.Job;
import com.example.jobmicroservice.data.JobRepository;
import com.example.jobmicroservice.data.JobService;
import com.example.jobmicroservice.dto.JobDTO;
import com.example.jobmicroservice.external.Company;
import com.example.jobmicroservice.external.Review;
import com.example.jobmicroservice.mapper.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class JobServiceImpl implements JobService {
    //private List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;

    @Autowired
    RestTemplate restTemplate;

    private CompanyClient companyClient;
    private ReviewClient reviewClient;

    public JobServiceImpl(JobRepository jobRepository, CompanyClient companyClient,
                          ReviewClient reviewClient){
        this.jobRepository = jobRepository;
        this.companyClient = companyClient;
        this.reviewClient = reviewClient;
    }

    @Override
    public List<JobDTO> findAll() {
        List<Job> jobs = jobRepository.findAll();
        List<JobDTO> jobDTOS = new ArrayList<>();

//       "http://localhost:8081/companies/ RestTemplate restTemplate = new Rest Template();
//
//        for(Job job :jobs){
//             JobWithCompanyDTO jobWithCompanyDTO = new JobWithCompanyDTO();
//             JobWithCompanyDTO.setJob(job);
//
//        Company company = restTemplate.getForObject(
//                    ",
//                    Company.class);

        return jobs.stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }
    private JobDTO convertToDto(Job job){
            Company company = companyClient.getCompany(job.getCompany_Id());
            List<Review> reviews = reviewClient.getReviews(job.getCompany_Id());

        return JobMapper.
                    mapToJobWithCompanyDto(job,company,reviews);
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);

    }

    @Override
    public JobDTO getJobById(Integer id) {
        Job job = jobRepository.findById(id).orElse(null);
        return convertToDto(job);
    }

    @Override
    public boolean deleteJobById(Integer id) {
        try{
            jobRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJob(Integer id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;
    }
}
