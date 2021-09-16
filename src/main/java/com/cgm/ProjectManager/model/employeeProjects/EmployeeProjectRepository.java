package com.cgm.ProjectManager.model.employeeProjects;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, String> {

    EmployeeProject findByEmployeeIdAndProjectId(Long employeeId, Long projectId);

    List<EmployeeProject> findAllByProjectId(Long projectId);
}
