package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.DonHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonHangDatabase {

    @Autowired
    private DonHangRepository donHangRepository;

    public DonHang createDonHang(String item, double price) {
        DonHang donHang = new DonHang();
        donHang.setItem(item);
        donHang.setPrice(price);
        return donHangRepository.save(donHang);
    }

    public DonHang getDonHang(Long id) {
        return donHangRepository.findById(id).orElse(null);
    }

    public DonHang updateDonHang(Long id, String item, double price) {
        DonHang donHang = donHangRepository.findById(id).orElse(null);
        if (donHang == null) {
            return null;
        }
        donHang.setItem(item);
        donHang.setPrice(price);
        return donHangRepository.save(donHang);
    }

    public void deleteDonHang(Long id) {
        donHangRepository.deleteById(id);
    }

    public Iterable<DonHang> getAllDonHangs() {
        return donHangRepository.findAll();
    }
}