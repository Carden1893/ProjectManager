package com.cgm.ProjectManager.model.employeeProjects;


import com.cgm.ProjectManager.model.employee.Employee;
import com.cgm.ProjectManager.model.project.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "employeeProject")
@Getter
@Setter
@NoArgsConstructor
public class EmployeeProject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "projectId", referencedColumnName = "projectId")
    private Project project;

    private Double capacity;

    public EmployeeProject(Employee employee, Project project, Double capacity){
        this.employee = employee;
        this.project = project;
        this.capacity = capacity;
    }

}
