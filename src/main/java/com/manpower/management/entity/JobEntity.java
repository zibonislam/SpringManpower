package com.manpower.management.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.eclipse.sisu.wire.WireModule;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@ToString
@RequiredArgsConstructor

public class JobEntity {
   @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String jobtitle;
    private String companyname;
    private String jobcontex;
    private String responsibilities;
    private String status;
    private String requirements;
    private String experience;
    private String salary;


}
