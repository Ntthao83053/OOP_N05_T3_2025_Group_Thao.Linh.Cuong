public class khachhang {
    String ten;
    String email;
    String sodienthoai;
    public khachhang(){

    }
    public khachhang(String ten, String email, String sdt){
        this.ten=ten;
        this.email=email;
        this.sodienthoai=sdt;
    }


    public void setten(String ten){
        this.ten=ten;
    }
    public void setemail(String email){
        this.email=email;
    }
    public void sodienthoai(String sodienthoai){
        this.sodienthoai=sodienthoai;
    }



    public String getten(){
        return ten;
    }
    public String getemail(){
        return email;
    }
    public String getsodienthoai(){
        return sodienthoai;
    }
    public String motaUser(){
        return "khachhang: " + ten + " email: " + email + " sodienthoai: " + sodienthoai;


    }
}
