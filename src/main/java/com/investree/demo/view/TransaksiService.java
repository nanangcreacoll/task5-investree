package com.investree.demo.view;

import com.investree.demo.model.Transaksi;
import java.util.Map;

public interface TransaksiService {
    public Map save(Transaksi transaksi);
    public Map updateStatus(Transaksi transaksi);
}
