package com.investree.demo.repository;

import com.investree.demo.model.Users;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsersRepository extends PagingAndSortingRepository<Users, Long> {
}
