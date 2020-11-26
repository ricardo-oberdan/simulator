package com.oberdan.simulator.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.oberdan.simulator.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

	public List<Transaction> findByAccount_accountId(final Long accountId, Sort sort);

}
