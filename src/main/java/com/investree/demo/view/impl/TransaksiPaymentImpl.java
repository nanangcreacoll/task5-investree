package com.investree.demo.view.impl;

import com.investree.demo.model.Transaksi;
import com.investree.demo.model.UserDetail;
import com.investree.demo.model.Users;
import com.investree.demo.repository.TransaksiRepository;
import com.investree.demo.repository.UserDetailRepository;
import com.investree.demo.repository.UsersRepository;
import com.investree.demo.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
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
            Transaksi obj = transaksiRepository.save(transaksi);
            map.put("data", obj);
            map.put("status", "Sukses");
            map.put("code", "200");
            return map;
        }
        catch (Exception e) {
            e.printStackTrace();
            map.put("status", e);
            map.put("code", "500");
            return map;
        }
    }

    @Override
    public Map updateStatus(Transaksi transaksi) {
        Map map = new HashMap();
        try {
            Transaksi obj = transaksiRepository.getById(transaksi.getId());

            if(obj == null){
                map.put("Message", "Data id tidak ditemukan");
                map.put("code", "404");
                return map;
            }

            obj.setStatus(transaksi.getStatus());
            transaksiRepository.save(obj);
            map.put("data", obj);
            map.put("status", "Sukses");
            map.put("code", "200");
            return map;
        }
        catch (Exception e) {
            e.printStackTrace();
            map.put("status", e);
            map.put("code", "500");
            return map;
        }
    }
}
