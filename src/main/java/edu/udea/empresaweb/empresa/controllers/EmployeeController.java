package edu.udea.empresaweb.empresa.controllers;


import edu.udea.empresaweb.empresa.entities.Employee;
import edu.udea.empresaweb.empresa.services.employeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    employeeServices service;

    public EmployeeController( employeeServices service){
        this.service = service;
    }

    @GetMapping("/user")
    public List<Employee> getEmployee(){
        return this.service.getEmployee();
    }

    @GetMapping("/user/{id}")
    public Employee getEmployee(@PathVariable("id") long id){
        return this.service.getEmployee(id);
    }

    @PostMapping("/user")
    public Employee createEmployee(@RequestBody Employee employee){
        return this.service.createEmployee(employee);
    }

    @PutMapping("/user/{id}")
    @ExceptionHandler
    public Employee updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
        return this.service.updateEmployee(id, employee);
    }


    @PatchMapping("/user/{id}")
    public Employee patchEmployee(@PathVariable("id") Long id, @RequestBody Map<Object, Object> objectMap){
        return this.service.patchEmployee(id, objectMap);
    }



    @DeleteMapping("/{id}")
    public Boolean deleteEmployee(@PathVariable("id") long id) {
        return this.service.deleteEmployee(id);
    }


}
