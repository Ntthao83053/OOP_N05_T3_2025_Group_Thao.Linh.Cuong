package com.example.servingwebcontent;

import com.example.servingwebcontent.database.DonHangRepository;
import com.example.servingwebcontent.model.DonHang;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class DonHangRepositoryTest {

    @Autowired
    private DonHangRepository donHangRepository;

    @Test
    public void testCreateDonHang() {
        DonHang donHang = new DonHang();
        donHang.setItem("Pizza");
        donHang.setPrice(10.99);
        DonHang savedDonHang = donHangRepository.save(donHang);
        assertThat(savedDonHang.getId()).isNotNull();
        assertThat(savedDonHang.getItem()).isEqualTo("Pizza");
    }
}