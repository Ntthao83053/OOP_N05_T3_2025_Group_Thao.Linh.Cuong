package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.database.EmployeeDatabase;
import com.example.servingwebcontent.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDatabase employeeDatabase;

    @PostMapping("/employee")
    public String createEmployee(@RequestParam String name, @RequestParam String role, @RequestParam double salary) {
        employeeDatabase.createEmployee(name, role, salary);
        return "redirect:/employee";
    }

    @GetMapping("/employee/{id}")
    public String getEmployee(@PathVariable Long id, Model model) {
        Employee employee = employeeDatabase.getEmployee(id);
        if (employee == null) {
            return "not-found";
        }
        model.addAttribute("employee", employee);
        return "employee-detail";
    }

    @PostMapping("/employee/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestParam String name, @RequestParam String role, @RequestParam double salary) {
        Employee employee = employeeDatabase.updateEmployee(id, name, role, salary);
        if (employee == null) {
            return "not-found";
        }
        return "redirect:/employee";
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeDatabase.deleteEmployee(id);
        return "redirect:/employee";
    }

    @GetMapping("/employee")
    public String listEmployee(Model model) {
        model.addAttribute("employees", employeeDatabase.getAllEmployees());
        return "employee-list";
    }
}