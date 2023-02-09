package com.manpower.management.relationshipexample.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString

public class RelationEntity {
    @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
    String Name;
    String email;
    String password;
}
