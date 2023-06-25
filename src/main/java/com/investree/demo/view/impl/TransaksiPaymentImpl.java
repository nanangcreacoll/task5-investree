package com.investree.demo.view.impl;

import com.investree.demo.model.Transaksi;
import com.investree.demo.model.Users;
import com.investree.demo.repository.TransaksiRepository;
import com.investree.demo.repository.UserDetailRepository;
import com.investree.demo.repository.UsersRepository;
import com.investree.demo.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;

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
        Transaksi obj = transaksiRepository.save(transaksi);


    }
}
