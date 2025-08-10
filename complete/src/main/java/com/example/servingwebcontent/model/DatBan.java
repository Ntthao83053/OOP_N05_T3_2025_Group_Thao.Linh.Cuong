public class DatBan {
    class DatBan:
    def __init__(self, ma_dat_ban, ten_khach_hang, so_ban, thoi_gian_dat, trang_thai="Chua xac nhan"):
        self.ma_dat_ban = ma_dat_ban
        self.ten_khach_hang = ten_khach_hang
        self.so_ban = so_ban
        self.thoi_gian_dat = thoi_gian_dat
        self.trang_thai = trang_thai

    def hien_thi_thong_tin(self):
        return f"Ma dat ban: {self.ma_dat_ban}, Ten khach: {self.ten_khach_hang}, So ban: {self.so_ban}, Thoi gian: {self.thoi_gian_dat}, Trang thai: {self.trang_thai}"
}
