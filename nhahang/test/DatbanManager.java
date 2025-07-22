
import java.util.ArrayList;

public class DatbanManager {
    private ArrayList<Datban> datbanList = new ArrayList<>();

    // Create
    public void addDatban(Datban db) {
        datbanList.add(db);
        System.out.println(" Đã thêm đặt bàn: " + db.getmaDatban());
    }

    // Read
    public void displayDatban(String maDatban) {
        for (Datban db : datbanList) {
            if (db.getmaDatban().equals(maDatban)) {
                System.out.println("----- Thông tin đặt bàn -----");
                System.out.println("Mã đặt bàn: " + db.getmaDatban());
                System.out.println("Mã khách hàng: " + db.getmaKhachhang());
                System.out.println("Mã bàn: " + db.getmaBan());
                System.out.println("Thời gian đặt: " + db.gettgDatban());
                System.out.println("Trạng thái: " + db.gettrangThai());
                return;
            }
        }
        System.out.println("⚠ Không tìm thấy đặt bàn có mã: " + maDatban);
    }

    // Update
    public void updateDatban(String maDatban, String trangThaiMoi) {
        for (Datban db : datbanList) {
            if (db.getmaDatban().equals(maDatban)) {
                db.settrangThai(trangThaiMoi);
                System.out.println("✏ Đã cập nhật trạng thái đặt bàn.");
                return;
            }
        }
        System.out.println("⚠ Không tìm thấy đặt bàn để cập nhật.");
    }

    // Delete
    public void deleteDatban(String maDatban) {
        Datban toRemove = null;
        for (Datban db : datbanList) {
            if (db.getmaDatban().equals(maDatban)) {
                toRemove = db;
                break;
            }
        }
        if (toRemove != null) {
            datbanList.remove(toRemove);
            System.out.println(" Đã xóa đặt bàn: " + maDatban);
        } else {
            System.out.println(" Không tìm thấy đặt bàn để xóa.");
        }
    }
}
