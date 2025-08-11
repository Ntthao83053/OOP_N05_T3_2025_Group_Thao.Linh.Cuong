package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDatabase {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(String name, String role, double salary) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setRole(role);
        employee.setSalary(salary);
        return employeeRepository.save(employee);
    }

    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee updateEmployee(Long id, String name, String role, double salary) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            return null;
        }
        employee.setName(name);
        employee.setRole(role);
        employee.setSalary(salary);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}