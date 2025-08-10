package com.example.servingwebcontent;

import com.example.servingwebcontent.controller.DatBanController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(DatBanController.class)
public class DatBanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testListDatBan() throws Exception {
        mockMvc.perform(get("/datban"))
                .andExpect(status().isOk())
                .andExpect(view().name("datban-list"));
    }
}