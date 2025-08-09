import java.util.ArrayList;
// Add the following import if TestQuanLyDatBan is in another package
// import your.package.name.TestQuanLyDatBan;

public class App {
    public static void main(String[] args) {
        DatBanController quanLy = new DatBanController();
        ArrayList<DatBan> danhSachDatBan = quanLy.nhapDanhSachDatBan();
        TestDatBanController.kiemThuHienThiDatBanTheoNgay(danhSachDatBan);
    }
}


