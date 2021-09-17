package com.cgm.ProjectManager.model.employee;

import com.cgm.ProjectManager.model.employeeProjects.EmployeeProject;
import com.cgm.ProjectManager.model.vacation.Vacation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private Long employeeId;
    private String firstName;
    private String lastName;
    private Double capacityLeft;
    private String unit;
    private boolean active;


    @OneToMany(mappedBy = "employee")
    private Set<EmployeeProject> employeeProjects;

    @OneToMany(mappedBy = "employee")
    private Set<Vacation> employeeVacations = new HashSet<>();

    public void addEmployeeProjects(EmployeeProject employeeProject){
        this.employeeProjects.add(employeeProject);
    }

    public void unassignFromProject(EmployeeProject employeeProject) {
        this.employeeProjects.remove(employeeProject);
    }
}
