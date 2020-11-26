package com.oberdan.simulator.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oberdan.simulator.entity.Account;
import com.oberdan.simulator.repository.AccountRepository;

@Service
public class AuthService implements UserDetailsService {

	@Autowired
	private AccountRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Account> account = repository.findById(Long.valueOf(username));
		if (account.isPresent())
			return account.get();
		else
			throw new UsernameNotFoundException("User not found");
	}
}
