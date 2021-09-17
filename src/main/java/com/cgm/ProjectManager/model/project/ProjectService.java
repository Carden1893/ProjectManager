package com.cgm.ProjectManager.model.project;

import com.cgm.ProjectManager.model.employee.Employee;
import com.cgm.ProjectManager.model.employee.EmployeeService;
import com.cgm.ProjectManager.model.employeeProjects.EmployeeProject;
import com.cgm.ProjectManager.model.employeeProjects.EmployeeProjectService;
import com.cgm.ProjectManager.model.ticket.Ticket;
import com.cgm.ProjectManager.model.ticket.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    private final EmployeeService employeeService;

    private final EmployeeProjectService employeeProjectService;

    private final TicketService ticketService;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, EmployeeService employeeService, EmployeeProjectService employeeProjectService, TicketService ticketService) {
        this.projectRepository = projectRepository;
        this.employeeService = employeeService;
        this.employeeProjectService = employeeProjectService;
        this.ticketService = ticketService;
    }


    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public Project getProject(Long projectId) {
        return projectRepository.findById(projectId).get();
    }

    /**
     * Deletes a Project, related Employees and Tickets
     * @param project
     */
    public void deleteProjectById(Project project) {
        //Get all Employees who are involved in the Project and unassign them all afterwards
        List<Employee> projectEmployees = employeeProjectService.getProjectEmployees(project);
        projectEmployees.forEach(employee -> {
            EmployeeProject employeeProject = employeeProjectService.findByEmployeeAndProject(employee, project);
            employee.unassignFromProject(employeeProject);
        });
        //Get all Tickets related ot the Project and delete them afterwards
        List<Ticket> ticketList = ticketService.getTicketsForProjectId(project);
        ticketList.forEach(ticket -> {
            ticketService.deleteTicketById(ticket.getTicketId());
        });
        //After all related Data were deleted the project gets deleted
        projectRepository.deleteById(project.getProjectId());
    }

    /**
     * Creates a single new Project
     * @param project
     */
    public void addProject(Project project) {
        projectRepository.save(project);
    }

    /**
     * Creates new Projects from a given List
     * @param projects
     */
    public void addProjects(List<Project> projects) {
        projectRepository.saveAll(projects);
    }

    /**
     * Assigns an employee to a project
     * Creates an EmployeeProject and also the links to it in Project and Employee
     * @param employeeId
     * @param projectId
     * @param capacity
     */
    public void assignEmployeeToProject(Long employeeId, Long projectId, Double capacity) {
        Employee employee = employeeService.getEmployee(employeeId);
        Project project = getProject(projectId);
        EmployeeProject employeeProject = new EmployeeProject(employee, project, capacity);
        employee.addEmployeeProjects(employeeProject);
        project.addProjectEmployee(employeeProject);
        employeeProjectService.saveEmployeeProject(employeeProject);
    }

    /**
     * unassigns an employee from a project
     * deletes the employeeProject and also the links to it in Project and Employee
     * @param employeeId
     * @param projectId
     */
    public void unassignEmployeeFromProject(Long employeeId, Long projectId) {
        Employee employee = employeeService.getEmployee(employeeId);
        Project project = getProject(projectId);
        EmployeeProject employeeProject = employeeProjectService.findByEmployeeAndProject(employee, project);
        employee.unassignFromProject(employeeProject);
        project.unassignEmployee(employeeProject);
        employeeProjectService.unassignEmployeeFromProject(employee,project);
    }


}
