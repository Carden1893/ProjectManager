package com.cgm.ProjectManager.model.projects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public Project getProject(String projectId) {
        return projectRepository.findById(projectId).get();
    }

    public void deleteProjectById(String projectId) {
        projectRepository.deleteById(projectId);
    }

    public void addProject(Project project) {
        projectRepository.save(project);
    }

    public void addProjects(List<Project> projects) {
        projectRepository.saveAll(projects);
    }
}
