package com.investree.demo.repository;

import com.investree.demo.model.RolePath;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePathRepository extends PagingAndSortingRepository<RolePath, Long> {
    RolePath findOneByName(String rolePathName);

    @Query(value = "SELECT p.* FROM role_path p " +
            "JOIN role r ON r.id = p.role_id " +
            "JOIN user_role ur ON ur.role_id = r.id " +
            "WHERE ur.user_id = ?1", nativeQuery = true)
    <T extends UserDetails> List<RolePath> findByUser(T user);
}
