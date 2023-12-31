package com.investree.demo.repository;

import com.investree.demo.model.PaymentHistory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeymentHistoryRepository extends PagingAndSortingRepository<PaymentHistory, Long> {
}
