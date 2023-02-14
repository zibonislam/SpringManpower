package com.manpower.management.repository;

import com.manpower.management.entity.TraineeUpdateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TraineeUpdateRepository extends JpaRepository<TraineeUpdateEntity, Long> {

    Optional<TraineeUpdateEntity> findById(long id);
}
