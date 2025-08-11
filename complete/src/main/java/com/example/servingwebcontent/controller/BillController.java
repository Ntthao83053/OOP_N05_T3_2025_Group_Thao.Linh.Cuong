package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.database.BillDatabase;
import com.example.servingwebcontent.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BillController {

    @Autowired
    private BillDatabase billDatabase;

    @PostMapping("/bill")
    public String createBill(@RequestParam Long customerId, @RequestParam double totalAmount, @RequestParam String items) {
        billDatabase.createBill(customerId, totalAmount, items);
        return "redirect:/bill";
    }

    @GetMapping("/bill/{id}")
    public String getBill(@PathVariable Long id, Model model) {
        Bill bill = billDatabase.getBill(id);
        if (bill == null) {
            return "not-found";
        }
        model.addAttribute("bill", bill);
        return "bill-detail";
    }

    @PostMapping("/bill/{id}")
    public String updateBill(@PathVariable Long id, @RequestParam Long customerId, @RequestParam double totalAmount, @RequestParam String items) {
        Bill bill = billDatabase.updateBill(id, customerId, totalAmount, items);
        if (bill == null) {
            return "not-found";
        }
        return "redirect:/bill";
    }

    @DeleteMapping("/bill/{id}")
    public String deleteBill(@PathVariable Long id) {
        billDatabase.deleteBill(id);
        return "redirect:/bill";
    }

    @GetMapping("/bill")
    public String listBill(Model model) {
        model.addAttribute("bills", billDatabase.getAllBills());
        return "bill-list";
    }
}