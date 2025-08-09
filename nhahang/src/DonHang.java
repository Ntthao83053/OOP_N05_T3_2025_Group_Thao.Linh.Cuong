public class DonHang {
    private String maDonhang;
    private String maKhachhang;
    private String maBan;
    private int tgDathang;
    private String trangThai;

    public DonHang(String maDonhang, String maKhachhang, String maBan, int tgDathang, String trangThai) {
        this.maDonhang = maDonhang;
        this.maKhachhang = maKhachhang;
        this.maBan = maBan;
        this.tgDathang = tgDathang;
        this.trangThai = trangThai;
    }

    public String getMaDonhang() { return maDonhang; }
    public void setMaDonhang(String maDonhang) { this.maDonhang = maDonhang; }
    public String getMaKhachhang() { return maKhachhang; }
    public void setMaKhachhang(String maKhachhang) { this.maKhachhang = maKhachhang; }
    public String getMaBan() { return maBan; }
    public void setMaBan(String maBan) { this.maBan = maBan; }
    public int getTgDathang() { return tgDathang; }
    public void setTgDathang(int tgDathang) { this.tgDathang = tgDathang; }
    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }
}