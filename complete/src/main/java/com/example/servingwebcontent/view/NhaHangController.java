package com.example.servingwebcontent.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
import java.util.ArrayList;
import java.util.List;

@Controller
public class NhaHangController {
    
    @Autowired
    private BillDatabase billDB;
    
    @Autowired
    private DatBanDatabase datBanDB;
    
    @Autowired
    private DonHangDatabase donHangDB;
    
    @Autowired
    private EmployeeDatabase employeeDB;
    
    @Autowired
    private KhachHangDatabase khachHangDB;
    
    @Autowired
    private MenuDatabase menuDB;

    @GetMapping("/")
    public String home(Model model) {
        try {
            // Lấy thống kê từ tất cả các bảng database
            List<Bill> bills = billDB.getAllBills();
            List<DatBan> datBans = datBanDB.getAllDatBans();
            List<DonHang> donHangs = donHangDB.getAllDonHangs();
            List<Employee> employees = employeeDB.getAllEmployees();
            List<KhachHang> khachHangs = khachHangDB.getAllKhachHangs();
            List<Menu> menus = menuDB.getAllMenus();

            // Thêm thống kê tổng quát vào model
            model.addAttribute("totalBills", bills.size());
            model.addAttribute("totalDatBans", datBans.size());
            model.addAttribute("totalDonHangs", donHangs.size());
            model.addAttribute("totalEmployees", employees.size());
            model.addAttribute("totalKhachHangs", khachHangs.size());
            model.addAttribute("totalMenus", menus.size());

            // Thêm dữ liệu cho giao diện 3 phần
            List<DonHang> recentOrders = donHangDB.getRecentDonHangs(5); // Lấy 5 đơn hàng gần đây
            model.addAttribute("recentOrders", recentOrders != null ? recentOrders : new ArrayList<>());

            List<Menu> menuItems = menuDB.getAllMenus(); // Lấy danh sách menu
            model.addAttribute("menuItems", menuItems != null ? menuItems : new ArrayList<>());

            List<DonHang> orderDetails = donHangDB.getAllDonHangs(); // Lấy tất cả chi tiết đơn hàng
            model.addAttribute("orderDetails", orderDetails != null ? orderDetails : new ArrayList<>());

        } catch (Exception e) {
            // Xử lý ngoại lệ và đặt giá trị mặc định khi có lỗi
            model.addAttribute("totalBills", 0);
            model.addAttribute("totalDatBans", 0);
            model.addAttribute("totalDonHangs", 0);
            model.addAttribute("totalEmployees", 0);
            model.addAttribute("totalKhachHangs", 0);
            model.addAttribute("totalMenus", 0);
            model.addAttribute("recentOrders", new ArrayList<>());
            model.addAttribute("menuItems", new ArrayList<>());
            model.addAttribute("orderDetails", new ArrayList<>());
            model.addAttribute("error", "Lỗi kết nối database: " + e.getMessage());
        }

        return "index";
    }

    
    @GetMapping("/db-status")
    public String dbStatus(Model model) {
        try {
            // Kiểm tra kết nối database và lấy thống kê từ tất cả các bảng
            List<Bill> bills = billDB.getAllBills();
            List<DatBan> datBans = datBanDB.getAllDatBans();
            List<DonHang> donHangs = donHangDB.getAllDonHangs();
            List<Employee> employees = employeeDB.getAllEmployees();
            List<KhachHang> khachHangs = khachHangDB.getAllKhachHangs();
            List<Menu> menus = menuDB.getAllMenus();
            
            model.addAttribute("isConnected", true);
            model.addAttribute("connectionInfo", "MySQL Database - Connected Successfully");
            model.addAttribute("totalBills", bills.size());
            model.addAttribute("totalDatBans", datBans.size());
            model.addAttribute("totalDonHangs", donHangs.size());
            model.addAttribute("totalEmployees", employees.size());
            model.addAttribute("totalKhachHangs", khachHangs.size());
            model.addAttribute("totalMenus", menus.size());
            model.addAttribute("employees", employees);  // Ví dụ lấy danh sách chi tiết cho một entity
        } catch (Exception e) {
            model.addAttribute("isConnected", false);
            model.addAttribute("connectionInfo", "MySQL Database - Connection Failed");
            model.addAttribute("error", "Lỗi kết nối database: " + e.getMessage());
            model.addAttribute("totalBills", 0);
            model.addAttribute("totalDatBans", 0);
            model.addAttribute("totalDonHangs", 0);
            model.addAttribute("totalEmployees", 0);
            model.addAttribute("totalKhachHangs", 0);
            model.addAttribute("totalMenus", 0);
            model.addAttribute("employees", null);
        }
        return "db-status";
    }
}