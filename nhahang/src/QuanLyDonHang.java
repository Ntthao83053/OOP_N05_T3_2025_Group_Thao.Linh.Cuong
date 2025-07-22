import java.util.ArrayList;

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
        for (DonHang dh : danhSachDonHang) {
            if (dh.getMaDonhang().equals(maDonhang)) {
                String trangThaiCu = dh.getTrangThai();
                dh.setTrangThai(trangThaiMoi);
                System.out.println("Đã cập nhật trạng thái đơn hàng '" + maDonhang + "' từ '" + trangThaiCu + "' sang '" + trangThaiMoi + "'.");
                return true;
            }
        }
        System.out.println("Không tìm thấy đơn hàng với mã: " + maDonhang);
        return false;
    }

    public void hienThiTatCaDonHang() {
        if (danhSachDonHang.isEmpty()) {
            System.out.println("Danh sách đơn hàng trống.");
            return;
        }
        System.out.println("Danh sách tất cả đơn hàng:");
        int i = 1;
        for (DonHang dh : danhSachDonHang) {
            System.out.println((i++) + ". " + dh);
        }
    }
}