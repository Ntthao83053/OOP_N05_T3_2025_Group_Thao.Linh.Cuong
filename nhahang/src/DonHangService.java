import java.util.ArrayList;
import java.util.List;

public class DonHangService {
    private List<DonHang> danhSachDonHang = new ArrayList<>();

    public void themDonHang(DonHang dh) {
        danhSachDonHang.add(dh);
    }

    public DonHang timDonHangTheoMa(String ma) {
        for (DonHang dh : danhSachDonHang) {
            if (dh.getMaDonhang().equals(ma)) return dh;
        }
        return null;
    }

    public boolean capNhatDonHang(String maDonhang, String maKH, String maBan, int tg, String trangThai) {
        DonHang dh = timDonHangTheoMa(maDonhang);
        if (dh != null) {
            dh.setMaKhachhang(maKH);
            dh.setMaBan(maBan);
            dh.setTgDathang(tg);
            dh.setTrangThai(trangThai);
            return true;
        }
        return false;
    }

    public boolean xoaDonHang(String maDonhang) {
        DonHang dh = timDonHangTheoMa(maDonhang);
        if (dh != null) {
            danhSachDonHang.remove(dh);
            return true;
        }
        return false;
    }
}