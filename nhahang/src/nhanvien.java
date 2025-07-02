public class nhanvien {
    String hovaten ;
    String tuoi ;
    String sodienthoai ;
    String diachi ;
    String gioitinh ;
    String cccd ;
    public nhanvien(String name, String tuoi, String sdt, String dc, String gt, String cccd){
        this.hovaten = name;
        this.tuoi = tuoi;
        this.sodienthoai = sdt;
        this.diachi = sdt;
        this.gioitinh = gt;
        this.cccd = cccd;
    }
public void hienthi1(){
    System.out.println("ho va ten: " + hovaten);
}    
}