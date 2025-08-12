package com.example.servingwebcontent;

import com.example.servingwebcontent.database.KhachHangRepository;
import com.example.servingwebcontent.database.DonHangRepository;
import com.example.servingwebcontent.model.KhachHang;
import com.example.servingwebcontent.model.DonHang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GreetingController {

    @Autowired
    private DonHangRepository donHangRepository;

    @Autowired
    private KhachHangRepository khachHangRepository;

    @GetMapping("/index")
    public String index(Model model) {
        // Tạo đối tượng DonHang (sử dụng các trường có sẵn: item và price)
        DonHang order = new DonHang();
        order.setItem("Bít tết, Salad rau trộn, Khoai tây chiên, Nước suối");
        order.setPrice(200000); // Tổng giá giả định

        // Tạo thông tin khách hàng
        KhachHang customer = new KhachHang();
        customer.setName("Nguyễn Văn An");
        customer.setEmail("nguyenvanan@example.com"); // Sử dụng trường email thay vì phone/note

        // Truyền dữ liệu vào model để Thymeleaf sử dụng
        model.addAttribute("order", order);
        model.addAttribute("customer", customer);
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