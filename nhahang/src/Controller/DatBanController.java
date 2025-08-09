import java.util.ArrayList;
import java.util.Scanner;

public class DatBanController {
    
    public ArrayList<DatBan> nhapDanhSachDatBan() {
        ArrayList<DatBan> danhSachDatBan = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập số lượng đặt bàn cần thêm: ");
        int soLuongDatBan = scanner.nextInt();
        scanner.nextLine(); // Xóa bộ đệm

        for (int i = 0; i < soLuongDatBan; i++) {
            System.out.println("Nhập thông tin đặt bàn " + (i + 1) + ":");
            System.out.print("Tên khách hàng: ");
            String tenKhachHang = scanner.nextLine();
            System.out.print("Số lượng người: ");
            int soNguoi = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm
            System.out.print("Thời gian đặt bàn (HH:mm): ");
            String gioDat = scanner.nextLine();
            System.out.print("Số bàn: ");
            int soBan = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm
            System.out.print("Ngày đặt bàn (dd/MM/yyyy): ");
            String ngayDat = scanner.nextLine();

            DatBan datBan = new DatBan(tenKhachHang, soNguoi, gioDat, soBan, ngayDat);
            danhSachDatBan.add(datBan);
        }

        return danhSachDatBan;
    }

    
    public void hienThiDatBanTheoNgay(ArrayList<DatBan> danhSachDatBan) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ngày cần hiển thị (dd/MM/yyyy): ");
        String ngayNhap = scanner.nextLine();

        System.out.println("Danh sách đặt bàn ngày " + ngayNhap + ":");
        boolean timThay = false;

        for (DatBan datBan : danhSachDatBan) {
            if (datBan.ngayDat.equals(ngayNhap)) {
                System.out.println("Tên khách hàng: " + datBan.tenKhachHang +
                        ", Số người: " + datBan.soNguoi +
                        ", Thời gian: " + datBan.gioDat +
                        ", Số bàn: " + datBan.soBan);
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Không có đặt bàn nào trong ngày " + ngayNhap);
        }
    }
}
