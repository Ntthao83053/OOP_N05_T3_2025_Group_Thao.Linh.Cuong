public class khachhang {
    String hovaten ;
    String tuoi ;
    String sodienthoai ;
    
    public khachhang(String name, String tuoi, String sdt){
        this.hovaten = name;
        this.tuoi = tuoi;
        this.sodienthoai = sdt;
        
    
    }
public void hienthi2(){
    System.out.println("ho va ten: " + hovaten);
}    
}