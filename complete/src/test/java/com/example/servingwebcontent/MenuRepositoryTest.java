package com.example.servingwebcontent;

import com.example.servingwebcontent.database.MenuRepository;
import com.example.servingwebcontent.model.Menu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class MenuRepositoryTest {

    @Autowired
    private MenuRepository menuRepository;

    @Test
    public void testCreateMenu() {
        Menu menu = new Menu();
        menu.setItemName("Pho bo");
        menu.setPrice(50000);
        menu.setDescription("Pho bo ngon");
        Menu savedMenu = menuRepository.save(menu);
        assertThat(savedMenu.getId()).isNotNull();
        assertThat(savedMenu.getItemName()).isEqualTo("Pho bo");
    }
}