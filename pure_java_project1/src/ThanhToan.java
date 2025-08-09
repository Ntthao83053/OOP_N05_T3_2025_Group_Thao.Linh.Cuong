// src/ThanhToan.java
package pure_java_project1.src;

import java.util.ArrayList;

public class ThanhToan {

    public void danhSachKhachDaThanhToan(ArrayList<KhachHang> danhSach) {
        System.out.println("Danh sách khách đã thanh toán:");
        danhSach.stream()
                .filter(KhachHang::isDaThanhToan)
                .forEach(kh -> System.out.println("ID: " + kh.getId() + ", Tên: " + kh.getTen()));
    }
}
