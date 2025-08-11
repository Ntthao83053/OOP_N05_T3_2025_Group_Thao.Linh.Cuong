package com.example.servingwebcontent;

import com.example.servingwebcontent.database.MenuDatabase;
import com.example.servingwebcontent.database.MenuRepository;
import com.example.servingwebcontent.model.Menu;
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
public class MenuDatabaseTest {

    @Autowired
    private MenuDatabase menuDatabase;

    @MockBean
    private MenuRepository menuRepository;

    @BeforeEach
    public void setUp() {
        Menu menu = new Menu();
        menu.setId(1L);
        menu.setItemName("Pho bo");
        menu.setPrice(50000);
        menu.setDescription("Pho bo ngon");
        when(menuRepository.save(any(Menu.class))).thenReturn(menu);
        when(menuRepository.findById(1L)).thenReturn(java.util.Optional.of(menu));
        when(menuRepository.findById(2L)).thenReturn(java.util.Optional.empty());
    }

    @Test
    public void testCreateMenu() {
        Menu menu = menuDatabase.createMenu("Bun cha", 40000, "Bun cha ngon");
        assertNotNull(menu);
        assertNotNull(menu.getId());
    }

    @Test
    public void testGetMenu() {
        Menu menu = menuDatabase.getMenu(1L);
        assertNotNull(menu);
        assertThat(menu.getItemName()).isEqualTo("Pho bo");
    }

    @Test
    public void testGetNonExistentMenu() {
        Menu menu = menuDatabase.getMenu(2L);
        assertNull(menu);
    }
}