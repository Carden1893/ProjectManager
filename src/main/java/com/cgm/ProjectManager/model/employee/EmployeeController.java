package com.cgm.ProjectManager.model.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/Employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping(path = "/Employee/{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") String employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @DeleteMapping(path = "/Employee/delete/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") String employeeId){
        employeeService.deleteEmployeeById(employeeId);
    }







}
