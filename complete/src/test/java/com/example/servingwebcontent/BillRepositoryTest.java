package com.example.servingwebcontent;

import com.example.servingwebcontent.database.BillRepository;
import com.example.servingwebcontent.model.Bill;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BillRepositoryTest {

    @Autowired
    private BillRepository billRepository;

    @Test
    public void testCreateBill() {
        Bill bill = new Bill();
        bill.setCustomerId(1L);
        bill.setTotalAmount(150000);
        bill.setItems("Pho bo, Bun cha");
        Bill savedBill = billRepository.save(bill);
        assertThat(savedBill.getId()).isNotNull();
        assertThat(savedBill.getTotalAmount()).isEqualTo(150000);
    }
}