import java.util.Scanner;

public class TestDatban {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập thông tin đặt bàn từ bàn phím
        System.out.print("Nhập mã khách hàng: ");
        String maKhachhang = scanner.nextLine();

        System.out.print("Nhập mã đặt bàn: ");
        String maDatban = scanner.nextLine();

        System.out.print("Nhập mã bàn: ");
        String maBan = scanner.nextLine();

        System.out.print("Nhập thời gian đặt (giờ): ");
        int tgDatban = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng thừa sau nextInt

        System.out.print("Nhập trạng thái đặt bàn: ");
        String trangThai = scanner.nextLine();

        // Tạo đối tượng từ dữ liệu vừa nhập
        Datban datban = new Datban(maKhachhang, maDatban, maBan, tgDatban, trangThai);

        // Hiển thị thông tin đặt bàn
        System.out.println("\nThông tin đặt bàn vừa nhập:");
        System.out.println("Mã khách hàng: " + datban.getMaKhachhang());
        System.out.println("Mã đặt bàn: " + datban.getMaDatban());
        System.out.println("Mã bàn: " + datban.getMaBan());
        System.out.println("Thời gian đặt: " + datban.getTgDatban());
        System.out.println("Trạng thái: " + datban.getTrangThai());

        // In bằng toString
        System.out.println("\nKết quả toString:");
        System.out.println(datban);

        scanner.close();
    }
}