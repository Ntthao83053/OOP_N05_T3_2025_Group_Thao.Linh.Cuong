package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.database.KhachHangDatabase;
import com.example.servingwebcontent.model.KhachHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class KhachHangController {

    @Autowired
    private KhachHangDatabase khachHangDatabase;

    @PostMapping("/khachhang")
    public String createKhachHang(@RequestParam String name, @RequestParam String email) {
        khachHangDatabase.createKhachHang(name, email);
        return "redirect:/khachhang";
    }

    @GetMapping("/khachhang/{id}")
    public String getKhachHang(@PathVariable Long id, Model model) {
        KhachHang khachHang = khachHangDatabase.getKhachHang(id);
        if (khachHang == null) {
            return "not-found";
        }
        model.addAttribute("khachHang", khachHang);
        return "khachhang-detail";
    }

    @PostMapping("/khachhang/{id}")
    public String updateKhachHang(@PathVariable Long id, @RequestParam String name, @RequestParam String email) {
        KhachHang khachHang = khachHangDatabase.updateKhachHang(id, name, email);
        if (khachHang == null) {
            return "not-found";
        }
        return "redirect:/khachhang";
    }

    @DeleteMapping("/khachhang/{id}")
    public String deleteKhachHang(@PathVariable Long id) {
        khachHangDatabase.deleteKhachHang(id);
        return "redirect:/khachhang";
    }

    @GetMapping("/khachhang")
    public String listKhachHang(Model model) {
        model.addAttribute("khachHangs", khachHangDatabase.getAllKhachHangs());
        return "khachhang-list";
    }
}