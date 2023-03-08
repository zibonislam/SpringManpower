package com.manpower.management.controller;


import com.manpower.management.entity.JobEntity;
import com.manpower.management.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class JobController {

    @Autowired
    JobRepository jobRepository;

    @PostMapping("/job/post")
    JobEntity newJob(@RequestBody JobEntity newJob) {
        System.out.println("test Hit");

        return jobRepository.save(newJob);
    }

    @GetMapping("/job/get")
    List<JobEntity> getAll() {
        System.out.println("test Hit");

        return jobRepository.findAll();
    }
    @GetMapping("/job/get/{id}")
    JobEntity one(@PathVariable Long id) {
        Optional<JobEntity> jobEntity =  jobRepository.findById(id);
        return jobEntity.get();
    }

    @PutMapping("/job/put/{id}")
    JobEntity job(@RequestBody JobEntity jobEntity, @PathVariable Long id) {

        return jobRepository.findById(id)
                .map(post -> {

                    post.setJobtitle(jobEntity.getJobtitle());
                    post.setCompanyname(jobEntity.getCompanyname());
                    post.setJobcontex(jobEntity.getJobcontex());
                    post.setResponsibilities(jobEntity.getResponsibilities());
                    post.setStatus(jobEntity.getStatus());
                    post.setRequirements(jobEntity.getRequirements());
                    post.setExperience(jobEntity.getExperience());
                    post.setSalary(jobEntity.getSalary());

                    return jobRepository.save(post);
                })
                .orElseGet(() -> {
                    jobEntity.setId(id);
                    return jobRepository.save(jobEntity);
                });
    }
    @DeleteMapping("/job/delete/{id}")
    void delete(@PathVariable Long id) {
        jobRepository.deleteById(id);
    }

}
