package com.example.servingwebcontent;

import com.example.servingwebcontent.database.FeedbackDatabase;
import com.example.servingwebcontent.model.Feedback;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FeedbackDatabaseTest {

    private FeedbackDatabase feedbackDatabase;

    @BeforeEach
    public void setUp() {
        feedbackDatabase = new FeedbackDatabase();
        feedbackDatabase.createFeedback("Test User", "Test feedback", 3);
    }

    @Test
    public void testCreateFeedback() {
        Feedback feedback = feedbackDatabase.createFeedback("New User", "New feedback", 5);
        assertNotNull(feedback);
        assertNotNull(feedback.getId());
        assertEquals("New User", feedback.getUserName());
    }

    @Test
    public void testReadFeedbackById() {
        Optional<Feedback> feedback = feedbackDatabase.readFeedbackById(1L);
        assertNotNull(feedback.orElse(null));
        assertEquals("Test User", feedback.get().getUserName());
    }

    @Test
    public void testUpdateFeedback() {
        boolean updated = feedbackDatabase.updateFeedback(1L, "Updated User", "Updated feedback", 4);
        Optional<Feedback> feedback = feedbackDatabase.readFeedbackById(1L);
        assertTrue(updated);
        assertEquals("Updated User", feedback.get().getUserName());
    }

    @Test
    public void testDeleteFeedback() {
        boolean deleted = feedbackDatabase.deleteFeedback(1L);
        Optional<Feedback> feedback = feedbackDatabase.readFeedbackById(1L);
        assertTrue(deleted);
        assertNull(feedback.orElse(null));
    }
}