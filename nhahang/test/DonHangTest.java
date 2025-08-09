public class DonHangTest {
    public static void main(String[] args) {
        DonHang dh = new DonHang("DH001", "KH123", "B01", 1030, "Đang xử lý");

        System.out.println("Mã đơn hàng: " + dh.getMaDonhang());
        System.out.println("Mã khách hàng: " + dh.getMaKhachhang());
        System.out.println("Mã bàn: " + dh.getMaBan());
        System.out.println("Thời gian đặt hàng: " + dh.getTgDathang());
        System.out.println("Trạng thái: " + dh.getTrangThai());

        dh.setTrangThai("Đã thanh toán");
        System.out.println("Trạng thái sau cập nhật: " + dh.getTrangThai());
    }
}
