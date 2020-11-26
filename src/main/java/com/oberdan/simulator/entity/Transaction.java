package com.oberdan.simulator.entity;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.oberdan.simulator.enums.CurrencyEnum;
import com.oberdan.simulator.enums.TransactionTypeEnum;

@Entity
@Table(name = "TRANSACTIONS")
public class Transaction {

	@Id
	@Column(name = "TRANSACTION_ID", nullable = false, unique = true, length = 32)
	private String id;

	@ManyToOne
	@JoinColumn(name = "ACCOUNT_ID")
	private Account account;

	@Column(name = "BOOKING_DATE", nullable = true)
	private ZonedDateTime bookingDate;

	@Column(name = "TRANSACTION_TYPE", nullable = true)
	@Enumerated(EnumType.ORDINAL)
	private TransactionTypeEnum type;

	@Column(name = "VALUE_DATE", nullable = true)
	private ZonedDateTime valueDate;

	@Column(name = "AMOUNG", nullable = true, precision = 10, scale = 2)
	private BigDecimal amount;

	@Column(name = "CURRENCY_CODE", nullable = true, length = 3)
	@Enumerated(EnumType.STRING)
	private CurrencyEnum currencyCode;

	@Column(name = "RUNNING_BALANCE", nullable = true, precision = 10, scale = 2)
	private BigDecimal runningBalance;

	@Column(name = "COUNTER_PARTY_ACCOUNT", nullable = true)
	private Long counterPartyAccountNumber;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public ZonedDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(ZonedDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public TransactionTypeEnum getType() {
		return type;
	}

	public void setType(TransactionTypeEnum type) {
		this.type = type;
	}

	public ZonedDateTime getValueDate() {
		return valueDate;
	}

	public void setValueDate(ZonedDateTime valueDate) {
		this.valueDate = valueDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public CurrencyEnum getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(CurrencyEnum currencyCode) {
		this.currencyCode = currencyCode;
	}

	public BigDecimal getRunningBalance() {
		return runningBalance;
	}

	public void setRunningBalance(BigDecimal runningBalance) {
		this.runningBalance = runningBalance;
	}

	public Long getCounterPartyAccountNumber() {
		return counterPartyAccountNumber;
	}

	public void setCounterPartyAccountNumber(Long counterPartyAccountNumber) {
		this.counterPartyAccountNumber = counterPartyAccountNumber;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", account=" + account + ", bookingDate=" + bookingDate + ", type=" + type
				+ ", valueDate=" + valueDate + ", amount=" + amount + ", currencyCode=" + currencyCode
				+ ", runningBalance=" + runningBalance + ", counterPartyAccountNumber=" + counterPartyAccountNumber
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Account))
			return false;
		Transaction transaction = (Transaction) obj;
		return Objects.equals(this.id, transaction.id);
	}

}
