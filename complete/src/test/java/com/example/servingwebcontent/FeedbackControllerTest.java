package com.example.servingwebcontent;

import com.example.servingwebcontent.controller.FeedbackController;
import com.example.servingwebcontent.database.FeedbackDatabase;
import com.example.servingwebcontent.model.Feedback;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FeedbackControllerTest {

    private FeedbackController controller;
    private FeedbackDatabase feedbackDatabase;
    private ByteArrayOutputStream outContent;
    @BeforeEach
    public void setUp() {
        feedbackDatabase = Mockito.mock(FeedbackDatabase.class);
        controller = new FeedbackController();
        controller.database = feedbackDatabase; // Inject mock
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testCreateFeedback() {
        String input = "1\nTest User\nTest feedback\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Feedback mockFeedback = new Feedback(1L, "Test User", "Test feedback", 5, new Date());
        Mockito.when(feedbackDatabase.createFeedback("Test User", "Test feedback", 5)).thenReturn(mockFeedback);

        controller.run(); // Chạy đến khi tạo feedback

        assertTrue(outContent.toString().contains("Da tao feedback"));
    }

    @Test
    public void testExit() {
        String input = "6\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        controller.run();

        assertTrue(outContent.toString().contains("Tam biet!"));
    }
}