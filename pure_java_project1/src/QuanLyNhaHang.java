// src/QuanLyNhaHang.java
package pure_java_project1.src;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyNhaHang {
    private Scanner scanner = new Scanner(System.in);

    // 1. Hiển thị khách đến trong ngày hiện tại
    public void hienThiKhachTrongNgay(ArrayList<KhachHang> danhSach) {
        LocalDate homNay = LocalDate.now();
        System.out.println("=== Danh sách khách đến hôm nay ===");
        danhSach.stream()
                .filter(kh -> kh.getThoiGianDen().toLocalDate().equals(homNay))
                .forEach(kh -> System.out.println("ID: " + kh.getId() + ", Tên: " + kh.getTen()));
    }

    // 2. Tìm kiếm khách theo tên (stream)
    public void timKiemKhachTheoTen(ArrayList<KhachHang> danhSach) {
        System.out.print("Nhập tên khách hàng cần tìm: ");
        String ten = scanner.nextLine();

        danhSach.stream()
                .filter(kh -> kh.getTen().equalsIgnoreCase(ten))
                .forEach(kh -> System.out.println("Tìm thấy: " + kh.getId() + " - " + kh.getTen()));
    }

    // 3. Cho khách xuất (đánh dấu đã thanh toán)
    public void xuatKhachTrongNgay(ArrayList<KhachHang> danhSach) {
        System.out.print("Nhập ID khách hàng cần xuất: ");
        String id = scanner.nextLine();

        danhSach.stream()
                .filter(kh -> kh.getId().equalsIgnoreCase(id))
                .findFirst()
                .ifPresent(kh -> {
                    kh.setDaThanhToan(true);
                    System.out.println("Khách " + kh.getTen() + " đã thanh toán và rời nhà hàng.");
                });
    }

    // 4. Hiển thị khách đủ điều kiện xuất (đã dùng món, chưa thanh toán)
    public void hienThiKhachDuDieuKienXuat(ArrayList<KhachHang> danhSach) {
        System.out.println("=== Danh sách khách đủ điều kiện xuất ===");
        danhSach.stream()
                .filter(kh -> !kh.isDaThanhToan() && kh.isDuDieuKienXuat())
                .forEach(kh -> System.out.println("ID: " + kh.getId() + ", Tên: " + kh.getTen()));
    }

    // 5. Cập nhật chuyển khách sang khu VIP (giống chuyển khoa hồi sức)
    public void chuyenKhachSangKhuVIP(ArrayList<KhachHang> danhSach) {
        System.out.print("Nhập ID khách chuyển sang VIP: ");
        String id = scanner.nextLine();

        danhSach.stream()
                .filter(kh -> kh.getId().equalsIgnoreCase(id))
                .findFirst()
                .ifPresent(kh -> {
                    kh.setDuDieuKienXuat(true);  // ví dụ đặt là khách đủ điều kiện phục vụ khu VIP
                    System.out.println("Khách " + kh.getTen() + " đã được chuyển sang khu VIP.");
                });
    }
}
