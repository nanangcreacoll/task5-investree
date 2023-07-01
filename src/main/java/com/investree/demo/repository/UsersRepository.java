package com.investree.demo.repository;

import com.investree.demo.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends PagingAndSortingRepository<Users, Long> {
    @Query("SELECT c FROM Users c WHERE c.id = :id")
    public Users getById(@Param("id") Long id);

    @Query("FROM Users c WHERE LOWER(c.username) = LOWER(?1)")
    Users findOneByUsername(String username);

    @Query("FROM Users c WHERE c.otp = ?1")
    Users findOneByOTP(String otp);
}
