package com.cgm.ProjectManager.model.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(String employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    public void deleteEmployeeById(String employeeId) {
        if (employeeRepository.existsById(employeeId))
            employeeRepository.deleteById(employeeId);
    }

    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void addEmployees(List<Employee> employees) {
        employeeRepository.saveAll(employees);
    }
}
