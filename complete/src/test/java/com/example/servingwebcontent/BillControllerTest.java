package com.example.servingwebcontent;

import com.example.servingwebcontent.controller.BillController;
import com.example.servingwebcontent.database.BillDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(BillController.class)
public class BillControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BillDatabase billDatabase;

    @Test
    public void testListBill() throws Exception {
        mockMvc.perform(get("/bill"))
                .andExpect(status().isOk())
                .andExpect(view().name("bill-list"));
    }
}