import java.util.ArrayList;
import java.util.Scanner;
import java.time.Instant;

class QuanLyDonHang {
    private ArrayList<DonHang> danhSachDonHang;
    public QuanLyDonHang() {
        this.danhSachDonHang = new ArrayList<>();
    }
    public void themDonHang(DonHang donHang) {
        danhSachDonHang.add(donHang);
        System.out.println("Đã thêm đơn hàng: " + donHang.getMaDonhang());
    }
    public boolean capNhatTrangThaiDonHang(String maDonhang, String trangThaiMoi) {
        System.out.println("\n--- Thực hiện Phương thức: Cập nhật Trạng thái Đơn hàng ---");
        for (DonHang dh : danhSachDonHang) {
            if (dh.getMaDonhang().equals(maDonhang)) {
                String trangThaiCu = dh.getTrangThai();
                dh.setTrangThai(trangThaiMoi);
                System.out.println("Thông báo: Đã cập nhật trạng thái đơn hàng '" + maDonhang + "' từ '" + trangThaiCu + "' sang '" + trangThaiMoi + "'.");
                System.out.println("Thông tin đơn hàng sau cập nhật: " + dh);
                return true;
            }
        }
        System.out.println("Lỗi: Không tìm thấy đơn hàng với mã '" + maDonhang + "'.");
        return false;
    }
    public void hienThiTatCaDonHang() {
        if (danhSachDonHang.isEmpty()) {
            System.out.println("\nThông báo: Danh sách đơn hàng hiện đang trống.");
        }
        System.out.println("\n--- Danh sách tất cả Đơn hàng trong hệ thống ---");
        for (int i = 0; i < danhSachDonHang.size(); i++) {
            System.out.println((i + 1) + ". " + danhSachDonHang.get(i));
        }
    }
}