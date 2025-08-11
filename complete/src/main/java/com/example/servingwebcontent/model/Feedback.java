package com.example.servingwebcontent.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity  // Thêm annotation này để JPA nhận diện là entity
public class Feedback {
    @Id  // Chỉ định trường khóa chính
    @GeneratedValue(strategy = GenerationType.AUTO)  // Tự động tạo ID
    private Long id;
    private String userName;
    private String content;
    private int rating;
    private Date date;

    public Feedback() {}  // Constructor mặc định cho JPA

    public Feedback(Long id, String userName, String content, int rating, Date date) {
        this.id = id;
        this.userName = userName;
        this.content = content;
        this.rating = rating;
        this.date = date;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", content='" + content + '\'' +
                ", rating=" + rating +
                ", date=" + date +
                '}';
    }
}