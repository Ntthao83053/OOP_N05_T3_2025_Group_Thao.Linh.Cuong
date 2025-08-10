package com.example.servingwebcontent;

import com.example.servingwebcontent.database.DatBanDatabase;
import com.example.servingwebcontent.database.DatBanRepository;
import com.example.servingwebcontent.model.DatBan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class DatBanDatabaseTest {

    @Autowired
    private DatBanDatabase datBanDatabase;

    @MockBean
    private DatBanRepository datBanRepository;

    @BeforeEach
    public void setUp() {
        DatBan datBan = new DatBan();
        datBan.setId(1L);
        datBan.setTableNumber(5);
        datBan.setReservationTime(LocalDateTime.now());
        when(datBanRepository.save(any(DatBan.class))).thenReturn(datBan);
        when(datBanRepository.findById(1L)).thenReturn(java.util.Optional.of(datBan));
        when(datBanRepository.findById(2L)).thenReturn(java.util.Optional.empty());
    }

    @Test
    public void testCreateDatBan() {
        DatBan datBan = datBanDatabase.createDatBan(6, LocalDateTime.now());
        assertNotNull(datBan);
        assertNotNull(datBan.getId());
    }

    @Test
    public void testCreateDatBanWithReservedTable() {
        datBanDatabase.createDatBan(5, LocalDateTime.now()); // Đặt bàn 5
        assertThrows(IllegalStateException.class, () -> datBanDatabase.createDatBan(5, LocalDateTime.now()));
    }
}