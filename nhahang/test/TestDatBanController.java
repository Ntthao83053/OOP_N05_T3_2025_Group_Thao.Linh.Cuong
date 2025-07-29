import java.util.ArrayList;

public class TestDatBanController {
    public static void kiemThuHienThiDatBanTheoNgay(ArrayList<DatBan> danhSachDatBan) {
        DatBanController quanLy = new DatBanController();
        quanLy.hienThiDatBanTheoNgay(danhSachDatBan);
    }

    public static void main(String[] args) {
        DatBanController quanLy = new DatBanController();
        ArrayList<DatBan> danhSach = quanLy.nhapDanhSachDatBan();

        
        kiemThuHienThiDatBanTheoNgay(danhSach);
    }
}
