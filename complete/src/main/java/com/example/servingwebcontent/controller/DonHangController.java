package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.database.DonHangDatabase;
import com.example.servingwebcontent.model.DonHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DonHangController {

    @Autowired
    private DonHangDatabase donHangDatabase;

    @PostMapping("/donhang")
    public String createDonHang(@RequestParam String item, @RequestParam double price) {
        donHangDatabase.createDonHang(item, price);
        return "redirect:/donhang";
    }

    @GetMapping("/donhang/{id}")
    public String getDonHang(@PathVariable Long id, Model model) {
        DonHang donHang = donHangDatabase.getDonHang(id);
        if (donHang == null) {
            return "not-found";
        }
        model.addAttribute("donHang", donHang);
        return "donhang-detail";
    }

    @PostMapping("/donhang/{id}")
    public String updateDonHang(@PathVariable Long id, @RequestParam String item, @RequestParam double price) {
        DonHang donHang = donHangDatabase.updateDonHang(id, item, price);
        if (donHang == null) {
            return "not-found";
        }
        return "redirect:/donhang";
    }

    @DeleteMapping("/donhang/{id}")
    public String deleteDonHang(@PathVariable Long id) {
        donHangDatabase.deleteDonHang(id);
        return "redirect:/donhang";
    }

    @GetMapping("/donhang")
    public String listDonHang(Model model) {
        // Example: fetch all records, or use pagination (offset=0, limit=100)
        model.addAttribute("donHangs", donHangDatabase.getAllDonHangs(0, 100));
        return "donhang-list";
    }
}