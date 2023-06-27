package com.investree.demo.repository;

import com.investree.demo.model.Transaksi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaksiRepository extends JpaRepository<Transaksi, Long> {
    @Query("SELECT c FROM Transaksi c WHERE c.id = :id")
    public Transaksi getByID(@Param("id") Long id);

    @Query("SELECT c FROM Transaksi c WHERE c.status LIKE :status")
    Page<Transaksi> getByLikeStatus(String status, Pageable pageable);

    @Query("SELECT c FROM Transaksi c")
    Page<Transaksi> getAll(Pageable pageable);
}
