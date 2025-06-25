public class Main {
    public static void main(String[] args)  {
        nhanvien nv = new nhanvien("Nguyen van A", "18", "09xxxxxxxx","Hanoi","nu","7561266345");
        nv.hienthi1();

        khachhang kh = new khachhang("Nguyen Thanh B","19","03xxxxxxxxx");
        kh.hienthi2();

        hoadon hd = new hoadon("muoitam", "Bui Quang C","Haithangsau", 678) ;
        hd.hienthi3();
        
    }
}
