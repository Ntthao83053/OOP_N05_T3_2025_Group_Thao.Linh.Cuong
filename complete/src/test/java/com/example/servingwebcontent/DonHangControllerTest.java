package com.example.servingwebcontent;

import com.example.servingwebcontent.controller.DonHangController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(DonHangController.class)
public class DonHangControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testListDonHang() throws Exception {
        mockMvc.perform(get("/donhang"))
                .andExpect(status().isOk())
                .andExpect(view().name("donhang-list"));
    }
}