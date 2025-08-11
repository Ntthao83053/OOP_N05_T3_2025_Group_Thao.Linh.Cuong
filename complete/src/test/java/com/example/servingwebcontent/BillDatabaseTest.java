package com.example.servingwebcontent;

import com.example.servingwebcontent.database.BillDatabase;
import com.example.servingwebcontent.database.BillRepository;
import com.example.servingwebcontent.model.Bill;
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
public class BillDatabaseTest {

    @Autowired
    private BillDatabase billDatabase;

    @MockBean
    private BillRepository billRepository;

    @BeforeEach
    public void setUp() {
        Bill bill = new Bill();
        bill.setId(1L);
        bill.setCustomerId(1L);
        bill.setTotalAmount(150000);
        bill.setItems("Pho bo, Bun cha");
        when(billRepository.save(any(Bill.class))).thenReturn(bill);
        when(billRepository.findById(1L)).thenReturn(java.util.Optional.of(bill));
        when(billRepository.findById(2L)).thenReturn(java.util.Optional.empty());
    }

    @Test
    public void testCreateBill() {
        Bill bill = billDatabase.createBill(2L, 200000, "Com ga, Nuoc ep");
        assertNotNull(bill);
        assertNotNull(bill.getId());
    }

    @Test
    public void testGetBill() {
        Bill bill = billDatabase.getBill(1L);
        assertNotNull(bill);
        assertThat(bill.getTotalAmount()).isEqualTo(150000);
    }

    @Test
    public void testGetNonExistentBill() {
        Bill bill = billDatabase.getBill(2L);
        assertNull(bill);
    }
}