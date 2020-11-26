package com.oberdan.simulator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oberdan.simulator.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	public Account findByAccountKey(final String accountKey);

}
