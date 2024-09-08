package com.example.jobmicroservice.data;

import com.example.jobmicroservice.dto.JobDTO;

import java.util.List;

public interface JobService {
    List<JobDTO> findAll();
    void createJob(Job job);

    JobDTO getJobById(Integer id);

    boolean deleteJobById(Integer id);

    boolean updateJob(Integer id, Job updatedJob);
}
