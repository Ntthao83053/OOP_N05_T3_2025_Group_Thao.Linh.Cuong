package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillDatabase {

    @Autowired
    private BillRepository billRepository;

    public Bill createBill(Long customerId, double totalAmount, String items) {
        Bill bill = new Bill();
        bill.setCustomerId(customerId);
        bill.setTotalAmount(totalAmount);
        bill.setItems(items);
        return billRepository.save(bill);
    }

    public Bill getBill(Long id) {
        return billRepository.findById(id).orElse(null);
    }

    public Bill updateBill(Long id, Long customerId, double totalAmount, String items) {
        Bill bill = billRepository.findById(id).orElse(null);
        if (bill == null) {
            return null;
        }
        bill.setCustomerId(customerId);
        bill.setTotalAmount(totalAmount);
        bill.setItems(items);
        return billRepository.save(bill);
    }

    public void deleteBill(Long id) {
        billRepository.deleteById(id);
    }

    public Iterable<Bill> getAllBills() {
        return billRepository.findAll();
    }
}
