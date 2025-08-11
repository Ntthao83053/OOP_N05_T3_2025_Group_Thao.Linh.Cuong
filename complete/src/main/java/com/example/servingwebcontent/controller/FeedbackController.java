// FeedbackController.java (Console-based controller for input)
package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.database.FeedbackDatabase;
import com.example.servingwebcontent.model.Feedback;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class FeedbackController {
    public FeedbackDatabase database = new FeedbackDatabase();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("\n=== Quan Ly Feedback ===");
            System.out.println("1. Tao feedback moi");
            System.out.println("2. Doc tat ca feedback");
            System.out.println("3. Doc feedback theo ID");
            System.out.println("4. Sua feedback");
            System.out.println("5. Xoa feedback");
            System.out.println("6. Thoat");
            System.out.print("Nhap lua chon: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createFeedback();
                    break;
                case 2:
                    readAllFeedback();
                    break;
                case 3:
                    readFeedbackById();
                    break;
                case 4:
                    updateFeedback();
                    break;
                case 5:
                    deleteFeedback();
                    break;
                case 6:
                    System.out.println("Tam biet!");
                    return;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }

    private void createFeedback() {
        System.out.print("Nhap ten nguoi dung: ");
        String userName = scanner.nextLine();
        System.out.print("Nhap noi dung feedback: ");
        String content = scanner.nextLine();
        System.out.print("Nhap diem danh gia (1-5): ");
        int rating = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Feedback feedback = database.createFeedback(userName, content, rating);
        System.out.println("Da tao feedback: " + feedback);
    }

    private void readAllFeedback() {
        List<Feedback> feedbackList = database.readAllFeedback();
        if (feedbackList.isEmpty()) {
            System.out.println("Khong co feedback nao.");
        } else {
            feedbackList.forEach(System.out::println);
        }
    }

    private void readFeedbackById() {
        System.out.print("Nhap ID feedback: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        Optional<Feedback> feedback = database.readFeedbackById(id);
        System.out.println(feedback.orElse(null));
    }

    private void updateFeedback() {
        System.out.print("Nhap ID feedback can sua: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        System.out.print("Nhap ten nguoi dung moi (de trong neu khong thay doi): ");
        String userName = scanner.nextLine();
        if (userName.isEmpty()) userName = null;
        System.out.print("Nhap noi dung moi (de trong neu khong thay doi): ");
        String content = scanner.nextLine();
        if (content.isEmpty()) content = null;
        System.out.print("Nhap diem danh gia moi (0 neu khong thay doi): ");
        int rating = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        boolean updated = database.updateFeedback(id, userName, content, rating);
        System.out.println(updated ? "Da sua thanh cong." : "Khong tim thay feedback.");
    }

    private void deleteFeedback() {
        System.out.print("Nhap ID feedback can xoa: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        boolean deleted = database.deleteFeedback(id);
        System.out.println(deleted ? "Da xoa thanh cong." : "Khong tim thay feedback.");
    }

    public static void main(String[] args) {
        new FeedbackController().run();
    }
}