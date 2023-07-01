package com.investree.demo.repository;

import com.investree.demo.model.Client;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientRepository extends PagingAndSortingRepository {
    Client findOneByClientId(String clientId);
}
