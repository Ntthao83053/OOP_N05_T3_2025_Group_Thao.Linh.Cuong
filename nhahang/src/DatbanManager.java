import java.util.ArrayList;
import java.util.Scanner;

public class DatbanManager {
    private ArrayList<Datban> danhSachDatban = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

   
    public void themDatban() {
        System.out.print("Nhập mã khách hàng: ");
        String maKH = scanner.nextLine();
        System.out.print("Nhập mã đặt bàn: ");
        String maDB = scanner.nextLine();

        
        for (Datban db : danhSachDatban) {
            if (db.getMaDatban().equals(maDB)) {
                System.out.println("Mã đặt bàn đã tồn tại!");
                return;
            }
        }

        System.out.print("Nhập mã bàn: ");
        String maBan = scanner.nextLine();
        System.out.print("Nhập thời gian đặt bàn (giờ): ");
        int tg = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập trạng thái: ");
        String tt = scanner.nextLine();

        danhSachDatban.add(new Datban(maKH, maDB, maBan, tg, tt));
        System.out.println(" Thêm thành công!");
    }

    
    public void hienThiDatban() {
        if (danhSachDatban.isEmpty()) {
            System.out.println("Không có đặt bàn nào.");
            return;
        }
        for (Datban db : danhSachDatban) {
            System.out.println(db);
        }
    }

    
    public void suaDatban() {
        System.out.print("Nhập mã đặt bàn cần sửa: ");
        String maDB = scanner.nextLine();

        for (Datban db : danhSachDatban) {
            if (db.getMaDatban().equals(maDB)) {
                System.out.print("Nhập trạng thái mới: ");
                db.setTrangThai(scanner.nextLine());
                System.out.println(" Cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy mã đặt bàn.");
    }

    
    public void xoaDatban() {
        System.out.print("Nhập mã đặt bàn cần xoá: ");
        String maDB = scanner.nextLine();

        for (Datban db : danhSachDatban) {
            if (db.getMaDatban().equals(maDB)) {
                danhSachDatban.remove(db);
                System.out.println(" Xoá thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy mã đặt bàn.");
    }
}