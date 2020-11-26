package com.oberdan.simulator.dto;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.oberdan.simulator.enums.CreditDebitIndicatorEnum;
import com.oberdan.simulator.enums.CurrencyEnum;
import com.oberdan.simulator.enums.TransactionTypeEnum;

@JsonPropertyOrder({ "id", "arrangementId", "bookingDate", "type", "valueDate", "amount", "currencyCode", "currency",
		"creditDebitIndicator", "runningBalance", "counterPartyAccountNumber", "reference", "typeGroup",
		"instructedAmount" })
public class TransactionDto {

	private String id;
	private String arrangementId;
	private ZonedDateTime bookingDate;
	private TransactionTypeEnum type;
	private ZonedDateTime valueDate;
	private BigDecimal amount;
	private CurrencyEnum currencyCode;
	private CurrencyEnum currency;
	private CreditDebitIndicatorEnum creditDebitIndicator;
	private BigDecimal runningBalance;
	private Long counterPartyAccountNumber;
	private String reference;
	private TransactionTypeEnum typeGroup;
	private BigDecimal instructedAmount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getArrangementId() {
		return arrangementId;
	}

	public void setArrangementId(String arrangementId) {
		this.arrangementId = arrangementId;
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

	public CurrencyEnum getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyEnum currency) {
		this.currency = currency;
	}

	public CreditDebitIndicatorEnum getCreditDebitIndicator() {
		return creditDebitIndicator;
	}

	public void setCreditDebitIndicator(CreditDebitIndicatorEnum creditDebitIndicator) {
		this.creditDebitIndicator = creditDebitIndicator;
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

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public TransactionTypeEnum getTypeGroup() {
		return typeGroup;
	}

	public void setTypeGroup(TransactionTypeEnum typeGroup) {
		this.typeGroup = typeGroup;
	}

	public BigDecimal getInstructedAmount() {
		return instructedAmount;
	}

	public void setInstructedAmount(BigDecimal instructedAmount) {
		this.instructedAmount = instructedAmount;
	}

}
