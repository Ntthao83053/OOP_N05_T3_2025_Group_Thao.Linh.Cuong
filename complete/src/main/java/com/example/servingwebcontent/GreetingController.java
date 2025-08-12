package com.example.servingwebcontent;

import com.example.servingwebcontent.model.Customer;
import com.example.servingwebcontent.model.DonHang;
import com.example.servingwebcontent.model.OrderItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GreetingController {

    @GetMapping("/index")
    public String index(Model model) {
        // Tạo đối tượng DonHang
        DonHang order = new DonHang();
        order.setTableNo("5");
        order.setTime("12:00");
        order.setGuests(4);

        // Tạo danh sách món ăn
        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem(2, "Bít tết"));
        items.add(new OrderItem(1, "Salad rau trộn"));
        items.add(new OrderItem(1, "Khôai tây chiên"));
        items.add(new OrderItem(1, "Nước suối"));

        // Tạo thông tin khách hàng
        Customer customer = new Customer("Nguyễn Văn An", "0987654321", "Sinh nhật");

        // Gán dữ liệu vào order
        order.setItems(items);
        order.setCustomer(customer);

        // Truyền dữ liệu vào model để Thymeleaf sử dụng
        model.addAttribute("order", order);
        return "index"; // Trả về file index.html
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Trả về file login.html
    }

    @PostMapping("/login")
    public String loginProcess(@RequestParam String username, @RequestParam String password, Model model) {
        if ("admin".equals(username) && "12345".equals(password)) {
            return "redirect:/index"; // Chuyển hướng đến index sau khi đăng nhập thành công
        } else {
            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng!");
            return "login"; // Trả lại login.html với thông báo lỗi
        }
    }
}