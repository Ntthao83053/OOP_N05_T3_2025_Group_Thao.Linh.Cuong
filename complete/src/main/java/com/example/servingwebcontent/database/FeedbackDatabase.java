// FeedbackDatabase.java (Service-like class for in-memory storage)
package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.Feedback;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class FeedbackDatabase {
    private List<Feedback> feedbackList = new ArrayList<>();
    private Long nextId = 1L;

    public Feedback createFeedback(String userName, String content, int rating) {
        Feedback feedback = new Feedback(nextId++, userName, content, rating, new Date());
        feedbackList.add(feedback);
        return feedback;
    }

    public List<Feedback> readAllFeedback() {
        return new ArrayList<>(feedbackList);
    }

    public Optional<Feedback> readFeedbackById(Long id) {
        return feedbackList.stream().filter(f -> f.getId().equals(id)).findFirst();
    }

    public boolean updateFeedback(Long id, String userName, String content, int rating) {
        Optional<Feedback> optionalFeedback = readFeedbackById(id);
        if (optionalFeedback.isPresent()) {
            Feedback feedback = optionalFeedback.get();
            if (userName != null) feedback.setUserName(userName);
            if (content != null) feedback.setContent(content);
            if (rating != 0) feedback.setRating(rating);
            feedback.setDate(new Date()); // Update date
            return true;
        }
        return false;
    }

    public boolean deleteFeedback(Long id) {
        return feedbackList.removeIf(f -> f.getId().equals(id));
    }
}