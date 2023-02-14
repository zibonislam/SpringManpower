package com.manpower.management.controller;

import com.manpower.management.entity.TraineeUpdateEntity;
import com.manpower.management.repository.TraineeUpdateRepository;
import com.manpower.management.service.TraineeUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class TraineeUpdateController {
   @Autowired
   TraineeUpdateRepository traineeUpdateRepository;
    @Autowired
    TraineeUpdateService traineeUpdateService;



    @PostMapping("/trainee/update/posts")
    TraineeUpdateEntity newupdate(@RequestBody TraineeUpdateEntity newTrainee) {
        System.out.println("test Hit");

        return traineeUpdateRepository.save(newTrainee);
    }


    @GetMapping("/trainee/update/posts")
    List<TraineeUpdateEntity> getAll() {
        System.out.println("test Hit");

        return traineeUpdateRepository.findAll();
    }
    // Single item

    @GetMapping("/trainee/update/posts/{id}")
    TraineeUpdateEntity one(@PathVariable Long id) {
        Optional<TraineeUpdateEntity> traineeUpdateEntity =  traineeUpdateRepository.findById(id);
        return traineeUpdateEntity.get();
    }

    @PutMapping("/trainee/update/posts/{id}")
    TraineeUpdateEntity replacetrainee(@RequestBody TraineeUpdateEntity traineeUpdateEntity, @PathVariable Long id) {

        return traineeUpdateRepository.findById(id)
                .map(post -> {
                    post.setName(traineeUpdateEntity.getName());
                    post.setDob(traineeUpdateEntity.getDob());
                    post.setPassport(traineeUpdateEntity.getPassport());
                    post.setNid(traineeUpdateEntity.getNid());
                    post.setEmail(traineeUpdateEntity.getEmail());
                    post.setTrainee_status(traineeUpdateEntity.getTrainee_status());
                    post.setWork_permit(traineeUpdateEntity.getWork_permit());



                    return traineeUpdateRepository.save(post);
                })
                .orElseGet(() -> {
                    traineeUpdateEntity.setId(id);
                    return traineeUpdateRepository.save(traineeUpdateEntity);
                });
    }

    @DeleteMapping("/trainee/update/posts/{id}")
    void deleteTrainee(@PathVariable Long id) {
        traineeUpdateRepository.deleteById(id);
    }
    @GetMapping("trainee/get/{id}")
    public Optional<TraineeUpdateEntity> find(@PathVariable long id){
        return traineeUpdateService.findById(id);
    }

}

