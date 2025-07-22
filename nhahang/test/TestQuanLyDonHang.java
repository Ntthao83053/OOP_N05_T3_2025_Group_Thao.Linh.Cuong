import java.time.Instant;
import java.util.Scanner;

public class TestQuanLyDonHang {
    public void runTest() {
        QuanLyDonHang qldh = new QuanLyDonHang();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("--- Bắt đầu chương trình kiểm thử Hệ thống Quản lý Đơn hàng ---");
            System.out.print("Nhập số lượng đơn hàng cần thêm: ");
            int soLuong = Integer.parseInt(scanner.nextLine());

            for (int i = 1; i <= soLuong; i++) {
                System.out.println("\nNhập thông tin cho đơn hàng thứ " + i + ":");

                System.out.print("Mã đơn hàng: ");
                String maDH = scanner.nextLine();

                System.out.print("Mã khách hàng: ");
                String maKH = scanner.nextLine();

                System.out.print("Mã bàn (có thể để trống): ");
                String maBan = scanner.nextLine();
                if (maBan.isBlank()) maBan = null;

                int tgDat = (int) Instant.now().getEpochSecond(); // thời gian hiện tại

                System.out.print("Trạng thái đơn hàng: ");
                String trangThai = scanner.nextLine();

                DonHang donHang = new DonHang(maDH, maKH, maBan, tgDat, trangThai);
                qldh.themDonHang(donHang);
            }

            System.out.println("\n== Danh sách đơn hàng đã nhập ==");
            qldh.hienThiTatCaDonHang();

      
            System.out.print("\nNhập mã đơn hàng cần cập nhật trạng thái: ");
            String maDHCanCapNhat = scanner.nextLine();
            System.out.print("Nhập trạng thái mới: ");
            String trangThaiMoi = scanner.nextLine();
            qldh.capNhatTrangThaiDonHang(maDHCanCapNhat, trangThaiMoi);

            System.out.print("\nNhập mã đơn hàng không tồn tại để kiểm tra lỗi: ");
            String maDHKhongTonTai = scanner.nextLine();
            System.out.print("Nhập trạng thái mới (ví dụ: Đã hủy): ");
            String trangThaiKhongTonTai = scanner.nextLine();
            qldh.capNhatTrangThaiDonHang(maDHKhongTonTai, trangThaiKhongTonTai);

            System.out.println("\n== Danh sách đơn hàng sau cập nhật ==");
            qldh.hienThiTatCaDonHang();

            System.out.println("\n--- Kết thúc chương trình kiểm thử ---");
        }
    }
}