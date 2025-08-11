package com.example.servingwebcontent;

import com.example.servingwebcontent.controller.EmployeeController;
import com.example.servingwebcontent.database.EmployeeDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeDatabase employeeDatabase;

    @Test
    public void testListEmployee() throws Exception {
        mockMvc.perform(get("/employee"))
                .andExpect(status().isOk())
                .andExpect(view().name("employee-list"));
    }
}