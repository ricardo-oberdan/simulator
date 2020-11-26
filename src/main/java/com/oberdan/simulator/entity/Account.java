package com.oberdan.simulator.entity;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "ACCOUNTS")
public class Account implements UserDetails {

	private static final long serialVersionUID = 678106414154364709L;

	@Id
	@Column(name = "ACCOUNT_ID", nullable = false, unique = true)
	private Long accountId;

	@Column(name = "ACCOUNT_KEY", nullable = false, length = 32)
	private String accountKey;

	@Column(name = "ACCOUNT_OWNER", nullable = false, length = 50)
	private String name;

	@Column(name = "PASSWORD", nullable = false, length = 100)
	private String password;

	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
	List<Transaction> transactions;

	private String authorities = "ROLE_USER";
	
	public Account() {
	}

	public Account(Long accountId, String accountKey, String name, String password) {
		this.accountId = accountId;
		this.accountKey = accountKey;
		this.name = name;
		this.password = password;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountKey() {
		return accountKey;
	}

	public void setAccountKey(String accountKey) {
		this.accountKey = accountKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountKey=" + accountKey + ", name=" + name + ", password="
				+ password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.accountId, this.name, this.password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Account))
			return false;
		Account account = (Account) obj;
		return Objects.equals(this.accountId, account.accountId);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.stream(authorities.split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}

	@Override
	public String getUsername() {
		return this.getAccountId().toString();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
