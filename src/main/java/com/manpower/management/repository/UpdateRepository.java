package com.manpower.management.repository;

import com.manpower.management.entity.UpdateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UpdateRepository extends JpaRepository<UpdateEntity,Long> {
    Optional<UpdateEntity> findById(long id);
}
