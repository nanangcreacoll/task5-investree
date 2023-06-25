package com.investree.demo.repository;

import com.investree.demo.model.Transaksi;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TransaksiRepository extends PagingAndSortingRepository<Transaksi, Long> {
}
