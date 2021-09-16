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

    public EmployeeProject findByEmployeeIdAndProjectId(Long employeeId, Long projectId){
        return employeeProjectRepository.findByEmployeeIdAndProjectId(employeeId, projectId);
    }

    public void changeEmployeeCapacityForProject(Employee employee, Project project, double newCapacity){
        EmployeeProject employeeProject = findByEmployeeIdAndProjectId(employee.getEmployeeId(), project.getProjectId());
        employeeProject.setCapacity(newCapacity);
        employeeProjectRepository.saveAndFlush(employeeProject);
    }

    public void unassignEmployeeFromProject(Long employeeId, Long projectId){
        EmployeeProject employeeProjectToDelete = employeeProjectRepository.findByEmployeeIdAndProjectId(employeeId, projectId);
        employeeProjectRepository.delete(employeeProjectToDelete);
    }


    public List<Employee> getProjectEmployees(Long projectId) {
        List<EmployeeProject> allByProjectId = employeeProjectRepository.findAllByProjectId(projectId);
        List<Employee> projectEmployeeList = new ArrayList<>();
        allByProjectId.forEach(employeeProject -> {
            projectEmployeeList.add(employeeProject.getEmployee());
        });
        return projectEmployeeList;
    }
}
