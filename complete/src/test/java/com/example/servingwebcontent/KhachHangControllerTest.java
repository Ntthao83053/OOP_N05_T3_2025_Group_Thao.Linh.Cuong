package com.example.servingwebcontent;

import com.example.servingwebcontent.controller.KhachHangController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(KhachHangController.class)
public class KhachHangControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testListKhachHang() throws Exception {
        mockMvc.perform(get("/khachhang"))
                .andExpect(status().isOk())
                .andExpect(view().name("khachhang-list"));
    }
}