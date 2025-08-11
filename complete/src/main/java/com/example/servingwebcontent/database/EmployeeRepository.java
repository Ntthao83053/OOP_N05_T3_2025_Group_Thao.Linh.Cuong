package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}