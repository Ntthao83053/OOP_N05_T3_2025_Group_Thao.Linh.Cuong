public class TestDatban {
    public static void main(String[] args) {
      
        Datban datban = new Datban("KH001", "DB001", "B01", 18, "Đã đặt");

      
        System.out.println("Mã khách hàng: " + datban.getMaKhachhang()); 
        System.out.println("Mã đặt bàn: " + datban.getMaDatban());        
        System.out.println("Thời gian đặt: " + datban.getTgDatban());   
        System.out.println("Trạng thái: " + datban.getTrangThai());     

     
        datban.setMaKhachhang("KH002");
        datban.setMaDatban("DB002");
        datban.setMaBan("B02");
        datban.setTgDatban(20);
        datban.setTrangThai("Đã huỷ");

      
        System.out.println("\nSau khi cập nhật:");
        System.out.println("Mã khách hàng: " + datban.getMaKhachhang());  
        System.out.println("Mã đặt bàn: " + datban.getMaDatban());       
        System.out.println("Mã bàn: " + datban.getMaBan());            
        System.out.println("Thời gian đặt: " + datban.getTgDatban());  
        System.out.println("Trạng thái: " + datban.getTrangThai());   

       
        System.out.println("\nKết quả toString:");
        System.out.println(datban);
    }
}