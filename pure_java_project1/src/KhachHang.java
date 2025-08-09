// src/KhachHang.java
package pure_java_project1.src;

import java.time.LocalDateTime;

public class KhachHang {
    private String id;
    private String ten;
    private LocalDateTime thoiGianDen;
    private boolean daThanhToan;
    private boolean duDieuKienXuat;

    public KhachHang(String id, String ten, LocalDateTime thoiGianDen) {
        this.id = id;
        this.ten = ten;
        this.thoiGianDen = thoiGianDen;
        this.daThanhToan = false;
        this.duDieuKienXuat = false;
    }

    // Getters & Setters
    public String getId() { return id; }
    public String getTen() { return ten; }
    public LocalDateTime getThoiGianDen() { return thoiGianDen; }
    public boolean isDaThanhToan() { return daThanhToan; }
    public void setDaThanhToan(boolean daThanhToan) { this.daThanhToan = daThanhToan; }
    public boolean isDuDieuKienXuat() { return duDieuKienXuat; }
    public void setDuDieuKienXuat(boolean duDieuKienXuat) { this.duDieuKienXuat = duDieuKienXuat; }
}
