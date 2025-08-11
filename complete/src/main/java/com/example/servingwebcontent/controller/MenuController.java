package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.database.MenuDatabase;
import com.example.servingwebcontent.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MenuController {

    @Autowired
    private MenuDatabase menuDatabase;

    @PostMapping("/menu")
    public String createMenu(@RequestParam String itemName, @RequestParam double price, @RequestParam String description) {
        menuDatabase.createMenu(itemName, price, description);
        return "redirect:/menu";
    }

    @GetMapping("/menu/{id}")
    public String getMenu(@PathVariable Long id, Model model) {
        Menu menu = menuDatabase.getMenu(id);
        if (menu == null) {
            return "not-found";
        }
        model.addAttribute("menu", menu);
        return "menu-detail";
    }

    @PostMapping("/menu/{id}")
    public String updateMenu(@PathVariable Long id, @RequestParam String itemName, @RequestParam double price, @RequestParam String description) {
        Menu menu = menuDatabase.updateMenu(id, itemName, price, description);
        if (menu == null) {
            return "not-found";
        }
        return "redirect:/menu";
    }

    @DeleteMapping("/menu/{id}")
    public String deleteMenu(@PathVariable Long id) {
        menuDatabase.deleteMenu(id);
        return "redirect:/menu";
    }

    @GetMapping("/menu")
    public String listMenu(Model model) {
        model.addAttribute("menus", menuDatabase.getAllMenus());
        return "menu-list";
    }
}