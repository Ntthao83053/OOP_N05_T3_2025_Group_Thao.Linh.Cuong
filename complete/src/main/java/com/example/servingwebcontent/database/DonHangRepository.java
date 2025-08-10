package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonHangRepository extends JpaRepository<DonHang, Long> {
}