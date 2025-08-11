package com.example.servingwebcontent;

import com.example.servingwebcontent.controller.MenuController;
import com.example.servingwebcontent.database.MenuDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(MenuController.class)
public class MenuControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MenuDatabase menuDatabase;

    @Test
    public void testListMenu() throws Exception {
        mockMvc.perform(get("/menu"))
                .andExpect(status().isOk())
                .andExpect(view().name("menu-list"));
    }
}