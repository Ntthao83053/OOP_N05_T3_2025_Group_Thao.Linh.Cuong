package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
