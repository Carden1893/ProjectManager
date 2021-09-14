package com.cgm.ProjectManager.model.employee;

import com.cgm.ProjectManager.model.datatypes.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(method = RequestMethod.GET, headers = "action=getEmployees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @RequestMapping(method = RequestMethod.GET, headers = "action=getEmployeeById")
    public Employee getEmployeeById(@PathVariable("employeeId") Long employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @RequestMapping(method = RequestMethod.DELETE, headers = "action=deleteEmployee")
    public void deleteEmployee(@PathVariable("employeeId") Long employeeId){
        employeeService.deleteEmployeeById(employeeId);
    }

    @RequestMapping(method = RequestMethod.PUT, headers = "action=addEmployee")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.PUT, headers = "action=addEmployees")
    public void addEmployees(@RequestBody List<Employee> employees){
        employeeService.addEmployees(employees);
    }

}
