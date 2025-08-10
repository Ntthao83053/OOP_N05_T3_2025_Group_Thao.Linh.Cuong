package com.example.servingwebcontent;

import com.example.servingwebcontent.database.KhachHangDatabase;
import com.example.servingwebcontent.database.KhachHangRepository;
import com.example.servingwebcontent.model.KhachHang;
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
public class KhachHangDatabaseTest {

    @Autowired
    private KhachHangDatabase khachHangDatabase;

    @MockBean
    private KhachHangRepository khachHangRepository;

    @BeforeEach
    public void setUp() {
        KhachHang khachHang = new KhachHang();
        khachHang.setId(1L);
        khachHang.setName("John Doe");
        khachHang.setEmail("john@example.com");
        when(khachHangRepository.save(any(KhachHang.class))).thenReturn(khachHang);
        when(khachHangRepository.findById(1L)).thenReturn(java.util.Optional.of(khachHang));
        when(khachHangRepository.findById(2L)).thenReturn(java.util.Optional.empty());
    }

    @Test
    public void testCreateKhachHang() {
        KhachHang khachHang = khachHangDatabase.createKhachHang("Jane Doe", "jane@example.com");
        assertNotNull(khachHang);
        assertNotNull(khachHang.getId());
    }

    @Test
    public void testGetKhachHang() {
        KhachHang khachHang = khachHangDatabase.getKhachHang(1L);
        assertNotNull(khachHang);
        assertThat(khachHang.getName()).isEqualTo("John Doe");
    }

    @Test
    public void testGetNonExistentKhachHang() {
        KhachHang khachHang = khachHangDatabase.getKhachHang(2L);
        assertNull(khachHang);
    }
}