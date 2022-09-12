package edu.udea.empresaweb.empresa.services;

import edu.udea.empresaweb.empresa.entities.Employee;
import edu.udea.empresaweb.empresa.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class employeeServices {
    private EmployeeRepository employeeRepository;

    public employeeServices(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployee(){
        return this.employeeRepository.findAll();
    }

    public Employee getEmployee(Long id){
        Optional<Employee> employee = this.employeeRepository.findById(id);
        return employee.orElse(null);
    }

    public Employee createEmployee(Employee employee){
        return this.employeeRepository.save(employee);
    }


    public Employee updateEmployee(Long id, Employee employee){
        Optional<Employee> dbData = this.employeeRepository.findAllById(id);

        if(dbData.isPresent()){
            Employee e = dbData.get();
            e.setEmail(employee.getEmail());
            e.setProfile(employee.getProfile());
            e.setRole(employee.getRole());
            e.setCreatedAt(employee.getCreatedAt());
            e.setUpdateAt(employee.getUpdateAt());
            e.setEnterprise(employee.getEnterprise());
            this.employeeRepository.save(e);
            return e;
        }
        return null;
    }


    public Employee patchEmployee(Long id, Map<Object, Object> objectMap) {
        Employee employee = employeeRepository.findById(id).get();
        objectMap.forEach((key, value)->{
            Field field = ReflectionUtils.findField(Employee.class, (String) key);;
            field.setAccessible(true);
            ReflectionUtils.setField(field, employee, value);
        });
        return employeeRepository.save(employee);
    }

    public Boolean deleteEmployee(Long id){
        try{
            this.employeeRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
