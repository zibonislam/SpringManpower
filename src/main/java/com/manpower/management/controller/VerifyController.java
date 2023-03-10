package com.manpower.management.controller;


import com.manpower.management.entity.VerifyEntity;
import com.manpower.management.repository.VerifyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
//@CrossOrigin("*")
public class VerifyController {
    @Autowired
    VerifyRepository verifyRepository;
    @GetMapping("/verify/posts")
    List<VerifyEntity> all() {
        return verifyRepository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/verify/posts")
    VerifyEntity newPost(@RequestBody VerifyEntity newTrainee) {
      System.out.println("method checked");
        return verifyRepository.save(newTrainee);
    }

    // Single item

    @GetMapping("/verify/posts/{id}")
    VerifyEntity one(@PathVariable Long id) {
        Optional<VerifyEntity> verifyEntity =  verifyRepository.findById(id);
        return verifyEntity.get();
    }

    @PutMapping("verify/posts/{id}")
    VerifyEntity replacetrainee(@RequestBody VerifyEntity verifyEntity, @PathVariable Long id) {

        return verifyRepository.findById(id)
                .map(post -> {
                    post.setName(verifyEntity.getName());
                    post.setPassport(verifyEntity.getPassport());
                    post.setNid(verifyEntity.getNid());
                    post.setDob(verifyEntity.getDob());
                    post.setEmail(verifyEntity.getEmail());
                    return verifyRepository.save(post);
                })
                .orElseGet(() -> {
                    verifyEntity.setId(id);
                    return verifyRepository.save(verifyEntity);
                });
    }

    @DeleteMapping("/verify/posts/{id}")
    void deleteTrainee(@PathVariable Long id) {
        verifyRepository.deleteById(id);
    }

}
