package com.cgm.ProjectManager.model.project;

import com.cgm.ProjectManager.model.employee.Employee;
import com.cgm.ProjectManager.model.employeeProjects.EmployeeProject;
import com.cgm.ProjectManager.model.ticket.Ticket;
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
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "project")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long projectId;

    private String projectName;
    private Date startDate;
    private Date endDate;
    private Date hardeningBorder;
    private String query;
    private String queryForTicketsWithoutSubtasks;



    @OneToMany(mappedBy = "project")
    private Set<EmployeeProject> projectEmployees;

    @OneToMany(mappedBy = "project")
    private Set<Ticket> projectTickets = new HashSet<>();

    public void addProjectEmployee(EmployeeProject employeeProject) {
        this.projectEmployees.add(employeeProject);
    }

    public void unassignEmployee(EmployeeProject employeeProject) {
        this.projectEmployees.remove(employeeProject);
    }


}
