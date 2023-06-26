package com.investree.demo.view.impl;

import com.investree.demo.model.Transaksi;
import com.investree.demo.model.UserDetail;
import com.investree.demo.model.Users;
import com.investree.demo.repository.TransaksiRepository;
import com.investree.demo.repository.UserDetailRepository;
import com.investree.demo.repository.UsersRepository;
import com.investree.demo.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class TransaksiPaymentImpl implements TransaksiService {
    @Autowired
    public TransaksiRepository transaksiRepository;

    @Autowired
    public UsersRepository usersRepository;

    @Autowired
    public UserDetailRepository userDetailRepository;

    @Override
    public Map save(Transaksi transaksi) {
        Map map = new HashMap();
        try {
            Users peminjam = usersRepository.getbyID(transaksi.getPeminjam().getId());
            Users meminjam = usersRepository.getbyID(transaksi.getMeminjam().getId());
            transaksi.setPeminjam(peminjam);
            transaksi.setMeminjam(meminjam);
            UserDetail peminjamDetail = userDetailRepository.save(transaksi.getPeminjam().getUserDetail());
            UserDetail meminjamDetail = userDetailRepository.save(transaksi.getMeminjam().getUserDetail());
            Transaksi obj = transaksiRepository.save(transaksi);

            peminjamDetail.setUser(peminjam);
            meminjamDetail.setUser(meminjam);
            userDetailRepository.save(peminjamDetail);
            userDetailRepository.save(meminjamDetail);
            map.put("data", obj);
            map.put("statusCode", "200");
            map.put("statusMessage", "Sukses");
            return map;
        }
        catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }

    @Override
    public Map updateStatus(Transaksi transaksi) {
        Map map = new HashMap();
        try {
            Transaksi obj = transaksiRepository.getByID(transaksi.getId());

            if(obj == null ){
                map.put("statusCode", "404");
                map.put("statusMessage", "Data id tidak ditemukan");
                return map;
            }

            obj.setStatus(transaksi.getStatus());
            transaksiRepository.save(obj);
            map.put("data", obj);
            map.put("statusCode", "200");
            map.put("statusMessage", "Update Sukses");
            return map;
        }
        catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }
}
