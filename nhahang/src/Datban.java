public class Datban {
    private String maKhachhang;
    private String maDatban;
    private String maBan;
    private int tgDatban;
    private String trangThai;

    public String getmaKhachhang() {
        return maKhachhang;
    }

    public void setmaKhachhang(String maKH) {
        this.maKhachhang = maKH;
    }

    public String getmaBan() {
        return maBan;
    }

    public void setmaBan(String maBan) {
        this.maBan = maBan;
    }

    public int gettgDatban() {
        return tgDatban;
    }

    public void settgDatban(int tgDatban) {
        this.tgDatban = tgDatban;
    }

    public String gettrangThai() {
        return trangThai;
    }

    public void settrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getmaDatban() {
        return maDatban;
    }

    public void setmaDatban(String maDatban) {
        this.maDatban = maDatban;
    }
}
public void createDatban(Datban db) throws SQLException {
    String sql = "INSERT INTO datban(maDatban, maKhachhang, maBan, tgDatban, trangThai) VALUES (?, ?, ?, ?, ?)";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, db.getmaDatban());
    ps.setString(2, db.getmaKhachhang());
    ps.setString(3, db.getmaBan());
    ps.setInt(4, db.gettgDatban());
    ps.setString(5, db.gettrangThai());
    ps.executeUpdate();
}
public Datban getDatbanById(String maDatban) throws SQLException {
    String sql = "SELECT * FROM datban WHERE maDatban = ?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, maDatban);
    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
        Datban db = new Datban();
        db.setmaDatban(rs.getString("maDatban"));
        db.setmaKhachhang(rs.getString("maKhachhang"));
        db.setmaBan(rs.getString("maBan"));
        db.settgDatban(rs.getInt("tgDatban"));
        db.settrangThai(rs.getString("trangThai"));
        return db;
    }
    return null;
}
public void updateDatban(Datban db) throws SQLException {
    String sql = "UPDATE datban SET maKhachhang=?, maBan=?, tgDatban=?, trangThai=? WHERE maDatban=?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, db.getmaKhachhang());
    ps.setString(2, db.getmaBan());
    ps.setInt(3, db.gettgDatban());
    ps.setString(4, db.gettrangThai());
    ps.setString(5, db.getmaDatban());
    ps.executeUpdate();
}
public void deleteDatban(String maDatban) throws SQLException {
    String sql = "DELETE FROM datban WHERE maDatban=?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, maDatban);
    ps.executeUpdate();
}
