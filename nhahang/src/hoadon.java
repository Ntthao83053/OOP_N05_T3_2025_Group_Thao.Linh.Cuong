public class hoadon {
    String maHoaDon ;
    String tenKhachHang ;
    String ngaylap ;
    double tongtien ;
    
    public hoadon(String ma, String tenKH, String ngay, double tong){
        this.maHoaDon = ma;
        this.tenKhachHang = tenKH;
        this.ngaylap = ngay;
        this.tongtien = tong;
        
    }
public void hienthi3(){
    System.out.println("Hóa đơn mã: " + maHoaDon + "-Tổng tiền: " + tongtien +"VND");
}    
}