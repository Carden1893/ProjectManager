package com.cgm.ProjectManager.model.employeeProjects;


import com.cgm.ProjectManager.model.employee.Employee;
import com.cgm.ProjectManager.model.projects.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employeeProjects")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeProjects {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
    private Employee employee;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "projectId", referencedColumnName = "projectId")
    private Project project;

    private Double capacity;

}
