package com.example.servingwebcontent;

import com.example.servingwebcontent.database.EmployeeDatabase;
import com.example.servingwebcontent.database.EmployeeRepository;
import com.example.servingwebcontent.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EmployeeDatabaseTest {

    @Autowired
    private EmployeeDatabase employeeDatabase;

    @MockBean
    private EmployeeRepository employeeRepository;

    @BeforeEach
    public void setUp() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("Nguyen Van A");
        employee.setRole("Phuc vu");
        employee.setSalary(10000000);
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
        when(employeeRepository.findById(1L)).thenReturn(java.util.Optional.of(employee));
        when(employeeRepository.findById(2L)).thenReturn(java.util.Optional.empty());
    }

    @Test
    public void testCreateEmployee() {
        Employee employee = employeeDatabase.createEmployee("Tran Thi B", "Quan ly", 15000000);
        assertNotNull(employee);
        assertNotNull(employee.getId());
    }

    @Test
    public void testGetEmployee() {
        Employee employee = employeeDatabase.getEmployee(1L);
        assertNotNull(employee);
        assertThat(employee.getName()).isEqualTo("Nguyen Van A");
    }

    @Test
    public void testGetNonExistentEmployee() {
        Employee employee = employeeDatabase.getEmployee(2L);
        assertNull(employee);
    }
}