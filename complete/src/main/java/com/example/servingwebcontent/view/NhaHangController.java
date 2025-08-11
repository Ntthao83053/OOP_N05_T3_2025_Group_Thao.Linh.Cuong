package com.example.servingwebcontent.view;

import com.example.servingwebcontent.database.BillDatabase;
import com.example.servingwebcontent.database.DatBanDatabase;
import com.example.servingwebcontent.database.DonHangDatabase;
import com.example.servingwebcontent.database.EmployeeDatabase;
import com.example.servingwebcontent.database.KhachHangDatabase;
import com.example.servingwebcontent.database.MenuDatabase;
import com.example.servingwebcontent.model.Bill;
import com.example.servingwebcontent.model.DatBan;
import com.example.servingwebcontent.model.DonHang;
import com.example.servingwebcontent.model.Employee;
import com.example.servingwebcontent.model.KhachHang;
import com.example.servingwebcontent.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class NhaHangController {

    @Autowired
    private BillDatabase billDatabase;
    @Autowired
    private DatBanDatabase datBanDatabase;
    @Autowired
    private DonHangDatabase donHangDatabase;
    @Autowired
    private EmployeeDatabase employeeDatabase;
    @Autowired
    private KhachHangDatabase khachHangDatabase;
    @Autowired
    private MenuDatabase menuDatabase;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Sửa lỗi Iterable to List
        List<Bill> bills = StreamSupport.stream(billDatabase.getAllBills().spliterator(), false).collect(Collectors.toList());
        List<DatBan> datBans = StreamSupport.stream(datBanDatabase.getAllDatBans().spliterator(), false).collect(Collectors.toList());
        List<DonHang> donHangs = StreamSupport.stream(donHangDatabase.getAllDonHangs(0, Integer.MAX_VALUE).spliterator(), false).collect(Collectors.toList());
        List<Employee> employees = StreamSupport.stream(employeeDatabase.getAllEmployees().spliterator(), false).collect(Collectors.toList());
        List<KhachHang> khachHangs = StreamSupport.stream(khachHangDatabase.getAllKhachHangs().spliterator(), false).collect(Collectors.toList());
        List<Menu> menus = StreamSupport.stream(menuDatabase.getAllMenus().spliterator(), false).collect(Collectors.toList());

        // Thêm vào model
        model.addAttribute("bills", bills);
        model.addAttribute("datBans", datBans);
        model.addAttribute("donHangs", donHangs);
        model.addAttribute("employees", employees);
        model.addAttribute("khachHangs", khachHangs);
        model.addAttribute("menus", menus);

        return "dashboard"; // Tên template dashboard.html
    }

    @GetMapping("/recent-donhangs")
    public String recentDonHangs(Model model) {
        // Sử dụng phương thức mới
        List<DonHang> recentDonHangs = donHangDatabase.getRecentDonHangs(10); // Lấy 10 đơn hàng gần nhất
        model.addAttribute("recentDonHangs", recentDonHangs);
        return "recent-donhangs"; // Tên template
    }

    // Các phương thức khác nếu có...
}