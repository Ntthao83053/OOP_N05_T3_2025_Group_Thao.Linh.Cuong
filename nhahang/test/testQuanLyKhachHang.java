import java.util.Scanner;

public class testQuanLyKhachHang {
    public static void main(String[] args) {
        QuanLyKhachHang qlkh = new QuanLyKhachHang();

        System.out.println("=== TEST THÊM KHÁCH HÀNG ===");
        KhachHang kh1 = new KhachHang("KH01", "Nguyễn Văn A", "0909123456", "Hà Nội", "a@gmail.com");
        KhachHang kh2 = new KhachHang("KH02", "Trần Thị B", "0911222333", "TP.HCM", "b@gmail.com");

        qlkh.themKhachHangThuCong(kh1);
        qlkh.themKhachHangThuCong(kh2);

        qlkh.hienThiDanhSach();

        System.out.println("\n=== TEST SỬA THÔNG TIN KHÁCH HÀNG ===");
        Scanner sc1 = new Scanner("Nguyễn Văn A Updated\n0988112233\nHải Phòng\na_updated@gmail.com\n");
        qlkh.suaKhachHang("KH01", sc1);
        qlkh.hienThiDanhSach();

        System.out.println("\n=== TEST XÓA KHÁCH HÀNG ===");
        qlkh.xoaKhachHang("KH02");
        qlkh.hienThiDanhSach();

        System.out.println("\n=== TEST XÓA KHÔNG TỒN TẠI ===");
        qlkh.xoaKhachHang("KH99");

        sc1.close(); 
    }
}
