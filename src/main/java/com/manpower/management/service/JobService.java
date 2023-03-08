package com.manpower.management.service;

import com.manpower.management.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class JobService {
    @Autowired
    JobRepository jobRepository;
}
