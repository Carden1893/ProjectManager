package com.cgm.ProjectManager.model.projects;

import com.cgm.ProjectManager.model.employee.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String projectId;

    private String projectName;
    private Date startDate;
    private Date endDate;
    private Date hardeningBorder;
    private String filterString;



    @ManyToMany
    @JoinTable(
            name = "ProjectEmployees",
            joinColumns = @JoinColumn(name= "projectId"),
            inverseJoinColumns = @JoinColumn(name = "employeeId")
    )
    private Set<Employee> projectEmployees;
}
