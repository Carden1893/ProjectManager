package com.cgm.ProjectManager.model.projects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/project")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping(path = "/Projects")
    public List<Project> getProjects() {
        return projectService.getProjects();
    }

    @GetMapping(path = "/Project/{projectId}")
    public Project getProjectById(@PathVariable("projectId") String projectId) {
        return projectService.getProject(projectId);
    }

    @DeleteMapping(path = "/Project/delete/{projectId}")
    public void deleteProject(@PathVariable("projectId") String projectId){
        projectService.deleteProjectById(projectId);
    }

    @PutMapping()
    public void addProject(@RequestBody Project project){
        projectService.addProject(project);
    }

    @PutMapping()
    public void addProjects(@RequestBody List<Project> projects){
        projectService.addProjects(projects);
    }
}
