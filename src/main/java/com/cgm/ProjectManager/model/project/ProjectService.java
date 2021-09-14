package com.cgm.ProjectManager.model.project;

import com.cgm.ProjectManager.model.employee.Employee;
import com.cgm.ProjectManager.model.employee.EmployeeService;
import com.cgm.ProjectManager.model.employeeProjects.EmployeeProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    private final EmployeeService employeeService;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, EmployeeService employeeService) {
        this.projectRepository = projectRepository;
        this.employeeService = employeeService;
    }


    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public Project getProject(Long projectId) {
        return projectRepository.findById(projectId).get();
    }

    public void deleteProjectById(Long projectId) {
        projectRepository.deleteById(projectId);
    }

    public void addProject(Project project) {
        projectRepository.save(project);
    }

    public void addProjects(List<Project> projects) {
        projectRepository.saveAll(projects);
    }

    public void assignEmployeeToProject(Long employeeId, Long projectId, Double capacity) {
        Employee employee = employeeService.getEmployee(employeeId);
        Project project = getProject(projectId);
        EmployeeProject employeeProject = new EmployeeProject(employee, project, capacity);
        employee.addEmployeeProjects(employeeProject);
        project.addProjectEmployee(employeeProject);
    }

    public void updateProject(Project project){

    }


}
