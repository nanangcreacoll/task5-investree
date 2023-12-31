package com.investree.demo.repository;

import com.investree.demo.model.Client;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {
    Client findOneByClientId(String clientId);
}
