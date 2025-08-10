package com.example.servingwebcontent;

import com.example.servingwebcontent.database.DatBanRepository;
import com.example.servingwebcontent.model.DatBan;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class DatBanRepositoryTest {

    @Autowired
    private DatBanRepository datBanRepository;

    @Test
    public void testCreateDatBan() {
        DatBan datBan = new DatBan();
        datBan.setTableNumber(5);
        datBan.setReservationTime(LocalDateTime.now());
        DatBan savedDatBan = datBanRepository.save(datBan);
        assertThat(savedDatBan.getId()).isNotNull();
        assertThat(savedDatBan.getTableNumber()).isEqualTo(5);
    }
}