
// FeedbackDatabaseTest.java (JUnit Test)
package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.Feedback;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class FeedbackDatabaseTest {
    private FeedbackDatabase database;

    @BeforeEach
    public void setUp() {
        database = new FeedbackDatabase();
    }

    @Test
    public void testCreateFeedback() {
        Feedback feedback = database.createFeedback("User1", "Good", 5);
        assertNotNull(feedback);
        assertEquals(1L, feedback.getId());
        assertEquals("User1", feedback.getUserName());
        assertEquals("Good", feedback.getContent());
        assertEquals(5, feedback.getRating());
        assertNotNull(feedback.getDate());
    }

    @Test
    public void testReadAllFeedback() {
        database.createFeedback("User1", "Good", 5);
        database.createFeedback("User2", "Bad", 1);
        List<Feedback> feedbackList = database.readAllFeedback();
        assertEquals(2, feedbackList.size());
    }

    @Test
    public void testReadFeedbackById() {
        database.createFeedback("User1", "Good", 5);
        Optional<Feedback> feedback = database.readFeedbackById(1L);
        assertTrue(feedback.isPresent());
        assertEquals("User1", feedback.get().getUserName());
    }

    @Test
    public void testUpdateFeedback() {
        database.createFeedback("User1", "Good", 5);
        boolean updated = database.updateFeedback(1L, "UserUpdated", "Better", 4);
        assertTrue(updated);
        Optional<Feedback> feedback = database.readFeedbackById(1L);
        assertEquals("UserUpdated", feedback.get().getUserName());
        assertEquals("Better", feedback.get().getContent());
        assertEquals(4, feedback.get().getRating());
    }

    @Test
    public void testDeleteFeedback() {
        database.createFeedback("User1", "Good", 5);
        boolean deleted = database.deleteFeedback(1L);
        assertTrue(deleted);
        Optional<Feedback> feedback = database.readFeedbackById(1L);
        assertFalse(feedback.isPresent());
    }
}