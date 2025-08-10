package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.KhachHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhachHangDatabase {

    @Autowired
    private KhachHangRepository khachHangRepository;

    public KhachHang createKhachHang(String name, String email) {
        KhachHang khachHang = new KhachHang();
        khachHang.setName(name);
        khachHang.setEmail(email);
        return khachHangRepository.save(khachHang);
    }

    public KhachHang getKhachHang(Long id) {
        return khachHangRepository.findById(id).orElse(null);
    }

    public KhachHang updateKhachHang(Long id, String name, String email) {
        KhachHang khachHang = khachHangRepository.findById(id).orElse(null);
        if (khachHang == null) {
            return null;
        }
        khachHang.setName(name);
        khachHang.setEmail(email);
        return khachHangRepository.save(khachHang);
    }

    public void deleteKhachHang(Long id) {
        khachHangRepository.deleteById(id);
    }

    public Iterable<KhachHang> getAllKhachHangs() {
        return khachHangRepository.findAll();
    }
}