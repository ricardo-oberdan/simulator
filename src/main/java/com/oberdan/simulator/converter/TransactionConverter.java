package com.oberdan.simulator.converter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.oberdan.simulator.dto.TransactionDto;
import com.oberdan.simulator.dto.TransactionInputDto;
import com.oberdan.simulator.entity.Account;
import com.oberdan.simulator.entity.Transaction;
import com.oberdan.simulator.enums.CreditDebitIndicatorEnum;
import com.oberdan.simulator.enums.CurrencyEnum;
import com.oberdan.simulator.enums.TransactionTypeEnum;

public class TransactionConverter {

	public static Transaction getEntityFromInput(TransactionInputDto dto, Account account) {
		Transaction transaction = new Transaction();
		transaction.setAccount(account);
		transaction.setId(dto.getEncodedKey());
		transaction.setBookingDate(ZonedDateTime.parse(dto.getCreationDate(), DateTimeFormatter.ISO_ZONED_DATE_TIME));
		transaction.setType(TransactionTypeEnum.valueOf(dto.getType()));
		transaction.setValueDate(ZonedDateTime.parse(dto.getValueDate(), DateTimeFormatter.ISO_ZONED_DATE_TIME));
		transaction.setCurrencyCode(CurrencyEnum.valueOf(dto.getCurrencyCode()));
		transaction.setRunningBalance(dto.getAccountBalances().getTotalBalance());
		transaction.setCounterPartyAccountNumber(Long.valueOf(dto.getId()));
		transaction.setAmount(dto.getAmount());
		
		return transaction;
	}
	
	public static TransactionDto getDto(Transaction transaction) {
		TransactionDto dto = new TransactionDto();
		dto.setAmount(transaction.getAmount());
		dto.setArrangementId(transaction.getAccount().getAccountKey());
		dto.setBookingDate(transaction.getBookingDate());
		dto.setCounterPartyAccountNumber(transaction.getCounterPartyAccountNumber());
		
		if (transaction.getAmount().signum() >= 0)
			dto.setCreditDebitIndicator(CreditDebitIndicatorEnum.CREDIT);
		else
			dto.setCreditDebitIndicator(CreditDebitIndicatorEnum.DEBIT);
		
		dto.setCurrency(transaction.getCurrencyCode());
		dto.setCurrencyCode(transaction.getCurrencyCode());
		dto.setId(transaction.getId());
		dto.setInstructedAmount(transaction.getAmount());
		dto.setReference(transaction.getAccount().getAccountKey());
		dto.setRunningBalance(transaction.getRunningBalance());
		dto.setType(transaction.getType());
		dto.setTypeGroup(transaction.getType());
		dto.setValueDate(transaction.getValueDate());		
		return dto;
	}

}