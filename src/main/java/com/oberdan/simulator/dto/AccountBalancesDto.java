package com.oberdan.simulator.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountBalancesDto {
	
	@JsonProperty("totalBalance")
	private BigDecimal totalBalance;


	public BigDecimal getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(BigDecimal totalBalance) {
		this.totalBalance = totalBalance;
	}

	@Override
	public String toString() {
		return "AccountBalancesDto [totalBalance=" + totalBalance + "]";
	}	
}
