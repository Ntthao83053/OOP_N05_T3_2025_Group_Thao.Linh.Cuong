package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}