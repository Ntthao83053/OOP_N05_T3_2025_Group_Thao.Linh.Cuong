public class DatBanController {
    class BoDieuKhienDatBan:
    def __init__(self):
        self.co_so_du_lieu = CoSoDuLieuDatBan()

    def xu_ly_tao_dat_ban(self, ten_khach_hang, so_ban, thoi_gian_dat):
        dat_ban = self.co_so_du_lieu.tao_dat_ban(ten_khach_hang, so_ban, thoi_gian_dat)
        return f"Da tao dat ban: {dat_ban.hien_thi_thong_tin()}"

    def xu_ly_doc_tat_ca(self):
        danh_sach = self.co_so_du_lieu.doc_tat_ca_dat_ban()
        if not danh_sach:
            return "Khong co dat ban nao."
        return danh_sach

    def xu_ly_doc_theo_ma(self, ma_dat_ban):
        return self.co_so_du_lieu.doc_dat_ban_theo_ma(ma_dat_ban)

    def xu_ly_sua_dat_ban(self, ma_dat_ban, **kwargs):
        return self.co_so_du_lieu.sua_dat_ban(ma_dat_ban, **kwargs)

    def xu_ly_xoa_dat_ban(self, ma_dat_ban):
        return self.co_so_du_lieu.xoa_dat_ban(ma_dat_ban)
}
