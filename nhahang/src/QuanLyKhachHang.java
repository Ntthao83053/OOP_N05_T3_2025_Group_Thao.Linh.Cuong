import java.util.ArrayList;
import java.util.Scanner;

class KhachHang {
    private String maKhachHang;
    private String tenKhachHang;
    private String soDienThoai;
    private String diaChi;
    private String email;

    public KhachHang(String maKhachHang, String tenKhachHang, String soDienThoai, String diaChi, String email) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.email = email;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "Mã='" + maKhachHang + '\'' +
                ", Tên='" + tenKhachHang + '\'' +
                ", SĐT='" + soDienThoai + '\'' +
                ", Địa chỉ='" + diaChi + '\'' +
                ", Email='" + email + '\'' +
                '}';
    }
}

public class QuanLyKhachHang {
    private ArrayList<KhachHang> danhSachKhachHang = new ArrayList<>();

    public void themKhachHang(Scanner sc) {
        System.out.print("Nhập mã KH: ");
        String ma = sc.nextLine();
        System.out.print("Nhập tên KH: ");
        String ten = sc.nextLine();
        System.out.print("Nhập số ĐT: ");
        String sdt = sc.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String diaChi = sc.nextLine();
        System.out.print("Nhập email: ");
        String email = sc.nextLine();

        KhachHang kh = new KhachHang(ma, ten, sdt, diaChi, email);
        danhSachKhachHang.add(kh);
        System.out.println("Thêm thành công!");
    }

    public void hienThiDanhSach() {
        if (danhSachKhachHang.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        for (KhachHang kh : danhSachKhachHang) {
            System.out.println(kh);
        }
    }

    public void suaKhachHang(String ma, Scanner sc) {
        for (KhachHang kh : danhSachKhachHang) {
            if (kh.getMaKhachHang().equals(ma)) {
                System.out.print("Nhập tên mới: ");
                kh.setTenKhachHang(sc.nextLine());
                System.out.print("Nhập số ĐT mới: ");
                kh.setSoDienThoai(sc.nextLine());
                System.out.print("Nhập địa chỉ mới: ");
                kh.setDiaChi(sc.nextLine());
                System.out.print("Nhập email mới: ");
                kh.setEmail(sc.nextLine());
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy KH.");
    }

    public void xoaKhachHang(String ma) {
        boolean removed = danhSachKhachHang.removeIf(kh -> kh.getMaKhachHang().equals(ma));
        if (removed) {
            System.out.println("Đã xóa khách hàng.");
       

 } else {
            System.out.println("Không tìm thấy khách hàng để xóa.");
        }
    }

public void themKhachHangThuCong(KhachHang khachHang) {
    danhSachKhachHang.add(khachHang);
}

    public static void main(String[] args) {
        QuanLyKhachHang ql = new QuanLyKhachHang();
        int luaChon;

        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println("\n--- MENU ---");
                System.out.println("1. Thêm khách hàng");
                System.out.println("2. Hiển thị danh sách khách hàng");
                System.out.println("3. Sửa thông tin khách hàng");
                System.out.println("4. Xóa khách hàng");
                System.out.println("0. Thoát");
                System.out.print("Chọn: ");
                try {
                    luaChon = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập số hợp lệ!");
                    luaChon = -1; 
                    continue;
                }

                switch (luaChon) {
                    case 1:
                        ql.themKhachHang(scanner);
                        break;
                    case 2:
                        ql.hienThiDanhSach();
                        break;
                    case 3:
                        System.out.print("Nhập mã KH cần sửa: ");
                        ql.suaKhachHang(scanner.nextLine(), scanner);
                        break;
                    case 4:
                        System.out.print("Nhập mã KH cần xóa: ");
                        ql.xoaKhachHang(scanner.nextLine());
                        break;
                    case 0:
                        System.out.println("Thoát chương trình.");
                        break;
                    default:
                        System.out.println("Chọn sai. Mời chọn lại!");
                }
            } while (luaChon != 0);
        }
    }
}