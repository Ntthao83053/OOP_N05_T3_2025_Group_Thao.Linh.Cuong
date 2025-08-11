package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}