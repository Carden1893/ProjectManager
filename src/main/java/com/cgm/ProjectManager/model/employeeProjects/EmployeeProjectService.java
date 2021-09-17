package com.cgm.ProjectManager.model.employeeProjects;

import com.cgm.ProjectManager.model.employee.Employee;
import com.cgm.ProjectManager.model.project.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeProjectService {

    private final EmployeeProjectRepository employeeProjectRepository;

    @Autowired
    public EmployeeProjectService(EmployeeProjectRepository employeeProjectRepository) {
        this.employeeProjectRepository = employeeProjectRepository;
    }

    public void saveEmployeeProject(EmployeeProject employeeProject){
        employeeProjectRepository.saveAndFlush(employeeProject);
    }

    public EmployeeProject findByEmployeeAndProject(Employee employee, Project project){
        return employeeProjectRepository.findByEmployeeAndProject(employee, project);
    }

    public void changeEmployeeCapacityForProject(Employee employee, Project project, double newCapacity){
        EmployeeProject employeeProject = findByEmployeeAndProject(employee, project);
        employeeProject.setCapacity(newCapacity);
        employeeProjectRepository.saveAndFlush(employeeProject);
    }

    public void unassignEmployeeFromProject(Employee employee, Project project){
        EmployeeProject employeeProjectToDelete = employeeProjectRepository.findByEmployeeAndProject(employee, project);
        employeeProjectRepository.delete(employeeProjectToDelete);
    }


    public List<Employee> getProjectEmployees(Project project) {
        List<EmployeeProject> allByProjectId = employeeProjectRepository.findAllByProject(project);
        List<Employee> projectEmployeeList = new ArrayList<>();
        allByProjectId.forEach(employeeProject -> {
            projectEmployeeList.add(employeeProject.getEmployee());
        });
        return projectEmployeeList;
    }
}
