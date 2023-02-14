package com.manpower.management.service;

import com.manpower.management.entity.TraineeUpdateEntity;
import com.manpower.management.repository.TraineeUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TraineeUpdateService {
    @Autowired
    TraineeUpdateRepository traineeUpdateRepository;

    public Optional<TraineeUpdateEntity> findById(long id) {
        return traineeUpdateRepository.findById(id);
    }
}
