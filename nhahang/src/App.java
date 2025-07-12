public class App {
    public static void test(String[] args)  {
        nhanvien nv = new nhanvien("Nguyen van A", "18", "09xxxxxxxx","Hanoi","nu","7561266345");
        nv.hienthi1();

        khachhang kh = new khachhang("Nguyen Thanh B","19","03xxxxxxxxx");
        kh.hienthi2();

        hoadon hd = new hoadon("muoitam", "Bui Quang C","Haithangsau", 678) ;
        hd.hienthi3();
        
    }
    DatbanManager manager = new DatbanManager();


        Datban db1 = new Datban();
        db1.setmaDatban("DB001");
        db1.setmaKhachhang("KH001");
        db1.setmaBan("B01");
        db1.settgDatban(1830);
        db1.settrangThai("Đang chờ");

        manager.addDatban(db1);

        
        manager.displayDatban("DB001");

        
        manager.updateDatban("DB001", "Đã xác nhận");
        manager.displayDatban("DB001");

        
        manager.deleteDatban("DB001");
        manager.displayDatban("DB001");  
    }
}
