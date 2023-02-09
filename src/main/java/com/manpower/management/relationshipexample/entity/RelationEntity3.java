package com.manpower.management.relationshipexample.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@ToString
public class RelationEntity3 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    String departmentname;
    String facultyname;
    String coursename;
}
