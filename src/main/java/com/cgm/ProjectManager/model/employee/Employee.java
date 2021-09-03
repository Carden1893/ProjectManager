package com.cgm.ProjectManager.model.employee;

import com.cgm.ProjectManager.model.datatypes.Unit;
import com.cgm.ProjectManager.model.employeeProjects.EmployeeProjects;
import com.cgm.ProjectManager.model.projects.Project;
import com.cgm.ProjectManager.model.vacation.Vacation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String employeeId;
    private String firstName;
    private String lastName;
    private Double capacityLeft;
    private Unit employeeType;
    private boolean active;


    @OneToMany(mappedBy = "employee")
    private Set<EmployeeProjects> employeeProjects;

    @OneToMany(mappedBy = "employee")
    private Set<Vacation> employeeVacations = new HashSet<>();






}
