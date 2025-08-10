package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.database.DatBanDatabase;
import com.example.servingwebcontent.model.DatBan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class DatBanController {

    @Autowired
    private DatBanDatabase datBanDatabase;

    @PostMapping("/datban")
    public String createDatBan(@RequestParam int tableNumber, @RequestParam LocalDateTime reservationTime) {
        try {
            datBanDatabase.createDatBan(tableNumber, reservationTime);
            return "redirect:/datban";
        } catch (IllegalStateException e) {
            return "error"; // Trang lỗi, cần tạo template error.html
        }
    }

    @GetMapping("/datban/{id}")
    public String getDatBan(@PathVariable Long id, Model model) {
        DatBan datBan = datBanDatabase.getDatBan(id);
        if (datBan == null) {
            return "not-found"; // Trang lỗi, cần tạo template not-found.html
        }
        model.addAttribute("datBan", datBan);
        return "datban-detail";
    }

    @PostMapping("/datban/{id}")
    public String updateDatBan(@PathVariable Long id, @RequestParam int tableNumber, @RequestParam LocalDateTime reservationTime) {
        try {
            DatBan datBan = datBanDatabase.updateDatBan(id, tableNumber, reservationTime);
            if (datBan == null) {
                return "not-found";
            }
            return "redirect:/datban";
        } catch (IllegalStateException e) {
            return "error";
        }
    }

    @DeleteMapping("/datban/{id}")
    public String deleteDatBan(@PathVariable Long id) {
        datBanDatabase.deleteDatBan(id);
        return "redirect:/datban";
    }

    @GetMapping("/datban")
    public String listDatBan(Model model) {
        model.addAttribute("datBans", datBanDatabase.getAllDatBans());
        return "datban-list";
    }
}