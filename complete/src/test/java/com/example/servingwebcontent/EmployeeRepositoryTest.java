package com.example.servingwebcontent;

import com.example.servingwebcontent.database.EmployeeRepository;
import com.example.servingwebcontent.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testCreateEmployee() {
        Employee employee = new Employee();
        employee.setName("Nguyen Van A");
        employee.setRole("Phuc vu");
        employee.setSalary(10000000);
        Employee savedEmployee = employeeRepository.save(employee);
        assertThat(savedEmployee.getId()).isNotNull();
        assertThat(savedEmployee.getName()).isEqualTo("Nguyen Van A");
    }
}