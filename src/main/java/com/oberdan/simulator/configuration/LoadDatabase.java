package com.oberdan.simulator.configuration;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oberdan.simulator.converter.TransactionConverter;
import com.oberdan.simulator.dto.TransactionInputDto;
import com.oberdan.simulator.entity.Account;
import com.oberdan.simulator.entity.Transaction;
import com.oberdan.simulator.repository.AccountRepository;
import com.oberdan.simulator.repository.TransactionRepository;

@Configuration
public class LoadDatabase {

	private static final Logger LOG = LoggerFactory.getLogger(LoadDatabase.class);
	
	@Bean
	public CommandLineRunner initDatabaseAccount(AccountRepository repository) {
		return args -> {
			LOG.info("Preloading Account" + repository.save(new Account(123L, "8a8587506b566dfd016b5add799444ec", "William", PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123"))));
			LOG.info("Preloading Account" + repository.save(new Account(456L, "8a8587506b566dfd016b5ae26a9344fc", "David", PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("456"))));
			LOG.info("Preloading Account" + repository.save(new Account(789L, "8a858e96689842d101689fd7d30a58ea", "Ricardo", PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("789"))));
			LOG.info("Preloading Account" + repository.save(new Account(0L, "8a220296689842d101689fd7d30a58ea", "Void", PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("0"))));
		};
	}

	@Bean
	public CommandLineRunner initDatabaseTransactions(TransactionRepository transactionRepository, AccountRepository accountRepository) {
		return args -> {

			Arrays.stream(getTransactionFromJson("transactions123.json"))
		       .forEach(dto -> {
		    	   Account account = accountRepository.findByAccountKey(dto.getParentAccountKey());
		    	   saveTransaction(transactionRepository, dto, account);   
		       });

			Arrays.stream(getTransactionFromJson("transactions456.json"))
		       .forEach(dto -> {
		    	   Account account = accountRepository.findByAccountKey(dto.getParentAccountKey());
		    	   saveTransaction(transactionRepository, dto, account);   
		       });
			
			Arrays.stream(getTransactionFromJson("transactions789.json"))
		       .forEach(dto -> {
		    	   Account account = accountRepository.findByAccountKey(dto.getParentAccountKey());
		    	   saveTransaction(transactionRepository, dto, account);   
		       });
			
		};
	}
	
	private TransactionInputDto[] getTransactionFromJson(String fileName) throws URISyntaxException, JsonParseException, JsonMappingException, IOException {
		Resource resource = new ClassPathResource(fileName);
	    File file = resource.getFile();
	    	
		TransactionInputDto[] dto = new ObjectMapper().readValue(file, TransactionInputDto[].class);
		return dto;
	}
	
	private void saveTransaction(TransactionRepository repository, TransactionInputDto dto, Account account) {
		
		//TODO: Usar mapstruct para fazer a conversao de tipos
		// Ao tentar a conversão, está levantando uma RuntimeException: Cannot find implementation for com.oberdan.simulator.mapper.TransactionInputMapper
		//Transaction transaction = TransactionInputMapper.INSTANCE.getEntity(dto);

		Transaction transaction = TransactionConverter.getEntityFromInput(dto, account);
		LOG.info("Preloading Transaction" + repository.save(transaction));
	}
	
	
}
