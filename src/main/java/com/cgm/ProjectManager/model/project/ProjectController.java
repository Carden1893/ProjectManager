package com.cgm.ProjectManager.model.project;


import com.cgm.ProjectManager.model.datatypes.dataObjects.MultipleEmployeesForProjectObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "api/project")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(method = RequestMethod.GET, headers = "action=getProjects")
    public List<Project> getProjects() {
        return projectService.getProjects();
    }

    @RequestMapping(method = RequestMethod.GET, headers = "action=getProjectById")
    public Project getProjectById(@RequestParam(value = "projectId") Long projectId) {
        return projectService.getProject(projectId);
    }

    @RequestMapping(method = RequestMethod.DELETE, headers = "action=deleteProject")
    public void deleteProject(@RequestParam(value = "projectId") Long projectId){
        projectService.deleteProjectById(projectId);
    }

    @RequestMapping(method = RequestMethod.POST, headers = "action=addProject")
    public void addProject(@RequestBody Project project){
        projectService.addProject(project);
    }

    @RequestMapping(method = RequestMethod.POST, headers = "action=addProjects")
    public void addProjects(@RequestBody List<Project> projects){
        projectService.addProjects(projects);
    }

    @RequestMapping(method = RequestMethod.POST, headers = "action=assignEmployeeToProject")
    public void assignEmployeeToProject(@RequestParam(value = "employeeId") Long employeeId,
                                        @RequestParam(value = "projectId") Long projectId,
                                        @RequestParam(value = "capacity") Double capacity){
        projectService.assignEmployeeToProject(employeeId, projectId, capacity);
    }

    @RequestMapping(method = RequestMethod.POST, headers = "action=assignMultipleEmployeesToProject")
    public void assignMultipleEmployeesToProject(@RequestBody MultipleEmployeesForProjectObject multipleEmployeesForProjectObject) {
        Long projectId = multipleEmployeesForProjectObject.getProjectId();
        HashMap<Long,Double> employeesAndCapacitites = multipleEmployeesForProjectObject.getEmployeesAndCapacities();

        employeesAndCapacitites.forEach((employeeId,capacity) -> {
            projectService.assignEmployeeToProject(employeeId, projectId, capacity);
        });
    }




}
