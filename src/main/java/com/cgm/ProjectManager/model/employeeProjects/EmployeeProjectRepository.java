package com.cgm.ProjectManager.model.employeeProjects;

import com.cgm.ProjectManager.model.employee.Employee;
import com.cgm.ProjectManager.model.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, String> {

    EmployeeProject findByEmployeeAndProject(Employee employee, Project project);

    List<EmployeeProject> findAllByProject(Project project);
}
