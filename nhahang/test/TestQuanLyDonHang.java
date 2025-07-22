import java.util.Scanner;
import java.time.Instant;

public class TestQuanLyDonHang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuanLyDonHang qldh = new QuanLyDonHang();

        System.out.println("CHƯƠNG TRÌNH QUẢN LÝ ĐƠN HÀNG");

        System.out.print("Nhập số lượng đơn hàng muốn thêm: ");
        int soLuong = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhập thông tin cho đơn hàng thứ " + (i + 1));
            System.out.print("Mã đơn hàng: ");
            String maDon = scanner.nextLine();

            System.out.print("Mã khách hàng: ");
            String maKH = scanner.nextLine();

            System.out.print("Mã bàn (có thể để trống): ");
            String maBan = scanner.nextLine();
            if (maBan.isEmpty()) maBan = null;

            int thoiGian = (int) Instant.now().getEpochSecond();

            System.out.print("Trạng thái: ");
            String trangThai = scanner.nextLine();

            DonHang donHang = new DonHang(maDon, maKH, maBan, thoiGian, trangThai);
            qldh.themDonHang(donHang);
        }

        System.out.println();
        qldh.hienThiTatCaDonHang();

        System.out.print("\nNhập mã đơn hàng cần cập nhật trạng thái: ");
        String maUpdate = scanner.nextLine();
        System.out.print("Trạng thái mới: ");
        String ttMoi = scanner.nextLine();
        qldh.capNhatTrangThaiDonHang(maUpdate, ttMoi);

        System.out.println();
        qldh.hienThiTatCaDonHang();

        scanner.close();
    }
}
