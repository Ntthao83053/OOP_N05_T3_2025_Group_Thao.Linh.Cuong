package com.example.servingwebcontent;

import com.example.servingwebcontent.database.DonHangDatabase;
import com.example.servingwebcontent.database.DonHangRepository;
import com.example.servingwebcontent.model.DonHang;
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
public class DonHangDatabaseTest {

    @Autowired
    private DonHangDatabase donHangDatabase;

    @MockBean
    private DonHangRepository donHangRepository;

    @BeforeEach
    public void setUp() {
        DonHang donHang = new DonHang();
        donHang.setId(1L);
        donHang.setItem("Pizza");
        donHang.setPrice(10.99);
        when(donHangRepository.save(any(DonHang.class))).thenReturn(donHang);
        when(donHangRepository.findById(1L)).thenReturn(java.util.Optional.of(donHang));
        when(donHangRepository.findById(2L)).thenReturn(java.util.Optional.empty());
    }

    @Test
    public void testCreateDonHang() {
        DonHang donHang = donHangDatabase.createDonHang("Burger", 8.99);
        assertNotNull(donHang);
        assertNotNull(donHang.getId());
    }

    @Test
    public void testGetDonHang() {
        DonHang donHang = donHangDatabase.getDonHang(1L);
        assertNotNull(donHang);
        assertThat(donHang.getItem()).isEqualTo("Pizza");
    }

    @Test
    public void testGetNonExistentDonHang() {
        DonHang donHang = donHangDatabase.getDonHang(2L);
        assertNull(donHang);
    }
}