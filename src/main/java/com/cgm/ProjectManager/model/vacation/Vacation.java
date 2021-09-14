package com.cgm.ProjectManager.model.vacation;

import com.cgm.ProjectManager.model.employee.Employee;
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
import java.util.Date;

@Entity
@Table(name = "vacation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vacationId;

    private Date vacationBegin;
    private Date vacationEnd;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
    private Employee employee;

}
