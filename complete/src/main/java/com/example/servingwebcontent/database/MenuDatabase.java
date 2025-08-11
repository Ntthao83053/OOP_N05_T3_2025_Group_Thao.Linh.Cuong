package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuDatabase {

    @Autowired
    private MenuRepository menuRepository;

    public Menu createMenu(String itemName, double price, String description) {
        Menu menu = new Menu();
        menu.setItemName(itemName);
        menu.setPrice(price);
        menu.setDescription(description);
        return menuRepository.save(menu);
    }

    public Menu getMenu(Long id) {
        return menuRepository.findById(id).orElse(null);
    }

    public Menu updateMenu(Long id, String itemName, double price, String description) {
        Menu menu = menuRepository.findById(id).orElse(null);
        if (menu == null) {
            return null;
        }
        menu.setItemName(itemName);
        menu.setPrice(price);
        menu.setDescription(description);
        return menuRepository.save(menu);
    }

    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }

    public Iterable<Menu> getAllMenus() {
        return menuRepository.findAll();
    }
}