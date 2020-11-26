package com.oberdan.simulator.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionInputDto {

	@JsonProperty("encodedKey")
	private String encodedKey;

	@JsonProperty("parentAccountKey")
	private String parentAccountKey;

	@JsonProperty("creationDate")
	private String creationDate;

	@JsonProperty("type")
	private String type;

	@JsonProperty("valueDate")
	private String valueDate;

	@JsonProperty("amount")
	private BigDecimal amount;

	@JsonProperty("currencyCode")
	private String currencyCode;

	@JsonProperty("accountBalances")
	private AccountBalancesDto accountBalances;

	@JsonProperty("id")
	private String id;
	
	public TransactionInputDto() {
	}

	public String getEncodedKey() {
		return encodedKey;
	}

	public void setEncodedKey(String encodedKey) {
		this.encodedKey = encodedKey;
	}

	public String getParentAccountKey() {
		return parentAccountKey;
	}

	public void setParentAccountKey(String parentAccountKey) {
		this.parentAccountKey = parentAccountKey;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValueDate() {
		return valueDate;
	}

	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public AccountBalancesDto getAccountBalances() {
		return accountBalances;
	}

	public void setAccountBalances(AccountBalancesDto accountBalances) {
		this.accountBalances = accountBalances;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "TransactionDto [encodedKey=" + encodedKey + ", parentAccountKey=" + parentAccountKey + ", creationDate="
				+ creationDate + ", type=" + type + ", valueDate=" + valueDate + ", amount=" + amount
				+ ", currencyCode=" + currencyCode + ", accountBalances=" + accountBalances + ", id=" + id + "]";
	}

}
