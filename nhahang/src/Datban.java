public class Datban {
    private String maKhachhang;
    private String maDatban;
    private String maBan;
    private int tgDatban;
    private String trangThai;

    public Datban(String maKhachhang, String maDatban, String maBan, int tgDatban, String trangThai) {
        this.maKhachhang = maKhachhang;
        this.maDatban = maDatban;
        this.maBan = maBan;
        this.tgDatban = tgDatban;
        this.trangThai = trangThai;
    }

    public String getMaKhachhang() {
        return maKhachhang;
    }

    public void setMaKhachhang(String maKH) {
        this.maKhachhang = maKH;
    }

    public String getMaDatban() {
        return maDatban;
    }

    public void setMaDatban(String maDatban) {
        this.maDatban = maDatban;
    }

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public int getTgDatban() {
        return tgDatban;
    }

    public void setTgDatban(int tgDatban) {
        this.tgDatban = tgDatban;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "Datban{" +
                "maKhachhang='" + maKhachhang + '\'' +
                ", maDatban='" + maDatban + '\'' +
                ", maBan='" + maBan + '\'' +
                ", tgDatban=" + tgDatban +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }
}