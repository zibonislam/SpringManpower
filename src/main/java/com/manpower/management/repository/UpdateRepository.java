package com.manpower.management.repository;

import com.manpower.management.entity.UpdateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdateRepository extends JpaRepository<UpdateEntity,Long> {
}
