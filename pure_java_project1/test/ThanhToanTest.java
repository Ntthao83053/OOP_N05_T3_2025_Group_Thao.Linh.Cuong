// test/ThanhToanTest.java
package pure_java_project1.test;

import pure_java_project1.src.KhachHang;
import pure_java_project1.src.ThanhToan;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ThanhToanTest {
    public void runTests() {
        ThanhToan tt = new ThanhToan();
        ArrayList<KhachHang> ds = new ArrayList<>();

        KhachHang kh1 = new KhachHang("KH01", "Nam", LocalDateTime.now());
        kh1.setDaThanhToan(true);
        ds.add(kh1);

        KhachHang kh2 = new KhachHang("KH02", "Hoa", LocalDateTime.now());
        ds.add(kh2);

        System.out.println("=== Danh sách khách đã thanh toán ===");
        tt.danhSachKhachDaThanhToan(ds);
    }
}
