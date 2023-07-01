package com.investree.demo.repository;

import com.investree.demo.model.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
    Role findOneByName(String name);

    List<Role> findByNameIn(String[] names);
}
