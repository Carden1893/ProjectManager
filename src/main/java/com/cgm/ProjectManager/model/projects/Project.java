package com.cgm.ProjectManager.model.projects;

import com.cgm.ProjectManager.model.ticket.Ticket;
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

    @OneToMany(mappedBy = "project")
    private Set<Ticket> projectTickets = new HashSet<>();
}
