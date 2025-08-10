public class DatBanDatabase {
    class CoSoDuLieuDatBan:
    def __init__(self):
        self.danh_sach_dat_ban = []
        self.ma_tu_tang = 1

    def tao_dat_ban(self, ten_khach_hang, so_ban, thoi_gian_dat):
        dat_ban_moi = DatBan(self.ma_tu_tang, ten_khach_hang, so_ban, thoi_gian_dat)
        self.danh_sach_dat_ban.append(dat_ban_moi)
        self.ma_tu_tang += 1
        return dat_ban_moi

    def doc_tat_ca_dat_ban(self):
        return [dat_ban.hien_thi_thong_tin() for dat_ban in self.danh_sach_dat_ban]

    def doc_dat_ban_theo_ma(self, ma_dat_ban):
        for dat_ban in self.danh_sach_dat_ban:
            if dat_ban.ma_dat_ban == ma_dat_ban:
                return dat_ban.hien_thi_thong_tin()
        return "Khong tim thay dat ban voi ma nay."

    def sua_dat_ban(self, ma_dat_ban, ten_khach_hang_moi=None, so_ban_moi=None, thoi_gian_dat_moi=None, trang_thai_moi=None):
        for dat_ban in self.danh_sach_dat_ban:
            if dat_ban.ma_dat_ban == ma_dat_ban:
                if ten_khach_hang_moi:
                    dat_ban.ten_khach_hang = ten_khach_hang_moi
                if so_ban_moi:
                    dat_ban.so_ban = so_ban_moi
                if thoi_gian_dat_moi:
                    dat_ban.thoi_gian_dat = thoi_gian_dat_moi
                if trang_thai_moi:
                    dat_ban.trang_thai = trang_thai_moi
                return "Da sua dat ban thanh cong."
        return "Khong tim thay dat ban de sua."

    def xoa_dat_ban(self, ma_dat_ban):
        for i, dat_ban in enumerate(self.danh_sach_dat_ban):
            if dat_ban.ma_dat_ban == ma_dat_ban:
                del self.danh_sach_dat_ban[i]
                return "Da xoa dat ban thanh cong."
        return "Khong tim thay dat ban de xoa."
}
