package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.DonHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonHangDatabase {

    @Autowired
    private DonHangRepository donHangRepository;

    /**
     * Tạo một đơn hàng mới với kiểm tra giá không âm.
     * @param item Tên món ăn
     * @param price Giá của món ăn
     * @return DonHang đã lưu hoặc null nếu giá không hợp lệ
     */
    public DonHang createDonHang(String item, double price) {
        if (item == null || item.trim().isEmpty() || price < 0) {
            return null; // Kiểm tra đầu vào
        }
        DonHang donHang = new DonHang();
        donHang.setItem(item);
        donHang.setPrice(price);
        return donHangRepository.save(donHang);
    }

    /**
     * Lấy thông tin đơn hàng theo ID.
     * @param id ID của đơn hàng
     * @return DonHang nếu tồn tại, null nếu không tìm thấy
     */
    public DonHang getDonHang(Long id) {
        return donHangRepository.findById(id).orElse(null);
    }

    /**
     * Cập nhật thông tin đơn hàng với kiểm tra tồn tại.
     * @param id ID của đơn hàng
     * @param item Tên món ăn mới
     * @param price Giá mới
     * @return DonHang đã cập nhật hoặc null nếu không tìm thấy
     */
    public DonHang updateDonHang(Long id, String item, double price) {
        DonHang donHang = donHangRepository.findById(id).orElse(null);
        if (donHang == null || item == null || item.trim().isEmpty() || price < 0) {
            return null;
        }
        donHang.setItem(item);
        donHang.setPrice(price);
        return donHangRepository.save(donHang);
    }

    /**
     * Xóa đơn hàng theo ID.
     * @param id ID của đơn hàng
     */
    public void deleteDonHang(Long id) {
        donHangRepository.deleteById(id);
    }

    /**
     * Lấy tất cả đơn hàng với tùy chọn phân trang.
     * @param page Số trang (bắt đầu từ 0)
     * @param size Số lượng phần tử mỗi trang
     * @return Iterable<DonHang> danh sách đơn hàng
     */
    public Iterable<DonHang> getAllDonHangs(int page, int size) {
        return donHangRepository.findAll(PageRequest.of(page, size, Sort.by("id")));
    }

    /**
     * Lấy danh sách n đơn hàng gần đây nhất (sắp xếp theo ID giảm dần).
     * @param limit Số lượng đơn hàng cần lấy
     * @return List<DonHang> danh sách đơn hàng
     */
    public List<DonHang> getRecentDonHangs(int limit) {
        return donHangRepository.findAll(PageRequest.of(0, limit, Sort.by(Sort.Direction.DESC, "id"))).getContent();
    }
}