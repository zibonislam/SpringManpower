package com.manpower.management.controller;


import com.manpower.management.entity.UpdateEntity;
import com.manpower.management.repository.UpdateRepository;
import com.manpower.management.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class UpdateController {
  @Autowired
  UpdateRepository updateRepository;

  @Autowired
  UpdateService updateService;


  @PostMapping("/update/posts")
  UpdateEntity newupdate(@RequestBody UpdateEntity newTrainee) {
    System.out.println("test Hit");

    return updateRepository.save(newTrainee);
  }


  @GetMapping("/update/posts")
  List<UpdateEntity> getAll() {
    System.out.println("test Hit");

    return updateRepository.findAll();
  }
  // Single item

  @GetMapping("/update/posts/{id}")
  UpdateEntity one(@PathVariable Long id) {
    Optional<UpdateEntity> updateEntity =  updateRepository.findById(id);
    return updateEntity.get();
  }

  @PutMapping("/update/posts/{id}")
  UpdateEntity replacetrainee(@RequestBody UpdateEntity updateEntity, @PathVariable Long id) {

    return updateRepository.findById(id)
      .map(post -> {
        post.setName(updateEntity.getName());
        post.setFathername(updateEntity.getFathername());
        post.setMothername(updateEntity.getMothername());
        post.setDob(updateEntity.getDob());
        post.setPassport(updateEntity.getPassport());
        post.setNid(updateEntity.getNid());
        post.setEmail(updateEntity.getEmail());
        post.setTraining(updateEntity.getTraining());
        post.setCompany(updateEntity.getCompany());
        post.setCountry(updateEntity.getCountry());


        return updateRepository.save(post);
      })
      .orElseGet(() -> {
        updateEntity.setId(id);
        return updateRepository.save(updateEntity);
      });
  }

  @DeleteMapping("/update/posts/{id}")
  void deleteTrainee(@PathVariable Long id) {
    updateRepository.deleteById(id);
  }

  @GetMapping("/get/{id}")
  public Optional<UpdateEntity> find(@PathVariable long id){
      return updateService.findById(id);
  }

}
