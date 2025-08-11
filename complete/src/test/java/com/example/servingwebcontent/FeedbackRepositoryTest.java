package com.example.servingwebcontent;

import com.example.servingwebcontent.database.FeedbackRepository;
import com.example.servingwebcontent.model.Feedback;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class FeedbackRepositoryTest {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Test
    public void testCreateFeedback() {
        Feedback feedback = new Feedback(1L, "John Doe", "Good service", 4, new Date());
        Feedback savedFeedback = feedbackRepository.save(feedback);
        assertThat(savedFeedback.getId()).isNotNull();
        assertThat(savedFeedback.getUserName()).isEqualTo("John Doe");
    }
}