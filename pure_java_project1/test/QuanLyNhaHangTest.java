// test/QuanLyNhaHangTest.java
package pure_java_project1.test;

import pure_java_project1.src.KhachHang;
import pure_java_project1.src.QuanLyNhaHang;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class QuanLyNhaHangTest {
    public void run() {
        ArrayList<KhachHang> danhSach = new ArrayList<>();
        QuanLyNhaHang ql = new QuanLyNhaHang();

        danhSach.add(new KhachHang("KH001", "Nam", LocalDateTime.now()));
        danhSach.add(new KhachHang("KH002", "Hoa", LocalDateTime.now()));
        danhSach.get(1).setDuDieuKienXuat(true);

        ql.hienThiKhachTrongNgay(danhSach);
        ql.timKiemKhachTheoTen(danhSach);
        ql.xuatKhachTrongNgay(danhSach);
        ql.hienThiKhachDuDieuKienXuat(danhSach);
        ql.chuyenKhachSangKhuVIP(danhSach);
    }
}
