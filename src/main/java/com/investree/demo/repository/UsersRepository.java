package com.investree.demo.repository;

import com.investree.demo.model.Transaksi;
import com.investree.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends PagingAndSortingRepository<Users, Long> {
    @Query("SELECT c FROM Users c WHERE c.id = :id")
    public Users getById(@Param("id") Long id);
}
