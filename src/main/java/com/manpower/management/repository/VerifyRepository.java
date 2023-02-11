package com.manpower.management.repository;

import com.manpower.management.entity.VerifyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerifyRepository extends JpaRepository<VerifyEntity, Long > {
}
