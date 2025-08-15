package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.DatBan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class DatBanDatabase {

    @Autowired
    private DatBanRepository datBanRepository;

    private Set<Integer> reservedTables = new HashSet<>(); // Theo dõi bàn đã đặt

    public DatBan createDatBan(int tableNumber, LocalDateTime reservationTime) {
        if (reservedTables.contains(tableNumber)) {
            throw new IllegalStateException("Table already reserved");
        }
        DatBan datBan = new DatBan();
        datBan.setTableNumber(tableNumber);
        datBan.setReservationTime(reservationTime);
        DatBan savedDatBan = datBanRepository.save(datBan);
        reservedTables.add(tableNumber);
        return savedDatBan;
    }

    public DatBan getDatBan(Long id) {
        return datBanRepository.findById(id).orElse(null);
    }

    public DatBan updateDatBan(Long id, int tableNumber, LocalDateTime reservationTime) {
        DatBan datBan = datBanRepository.findById(id).orElse(null);
        if (datBan == null) {
            return null;
        }
        if (tableNumber != datBan.getTableNumber() && reservedTables.contains(tableNumber)) {
            throw new IllegalStateException("Table already reserved");
        }
        reservedTables.remove(datBan.getTableNumber());
        datBan.setTableNumber(tableNumber);
        datBan.setReservationTime(reservationTime);
        return datBanRepository.save(datBan);
    }

    public void deleteDatBan(Long id) {
        DatBan datBan = datBanRepository.findById(id).orElse(null);
        if (datBan != null) {
            reservedTables.remove(datBan.getTableNumber());
            datBanRepository.deleteById(id);
        }
    }

    public Iterable<DatBan> getAllDatBans() {
        return datBanRepository.findAll();
    }
}
