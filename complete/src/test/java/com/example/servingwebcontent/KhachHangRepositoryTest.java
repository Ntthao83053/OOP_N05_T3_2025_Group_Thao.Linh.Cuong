package com.example.servingwebcontent;

import com.example.servingwebcontent.database.KhachHangRepository;
import com.example.servingwebcontent.model.KhachHang;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class KhachHangRepositoryTest {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Test
    public void testCreateKhachHang() {
        KhachHang khachHang = new KhachHang();
        khachHang.setName("John Doe");
        khachHang.setEmail("john@example.com");
        KhachHang savedKhachHang = khachHangRepository.save(khachHang);
        assertThat(savedKhachHang.getId()).isNotNull();
        assertThat(savedKhachHang.getName()).isEqualTo("John Doe");
    }
}