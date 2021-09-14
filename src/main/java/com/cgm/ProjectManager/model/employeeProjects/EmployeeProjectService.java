package com.cgm.ProjectManager.model.employeeProjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



}
