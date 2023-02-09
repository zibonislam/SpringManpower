package com.manpower.management.relationshipexample.repository;

import com.manpower.management.relationshipexample.entity.RelationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationRepository extends JpaRepository<RelationEntity,String> {
}
