package com.oberdan.simulator.endpoint;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oberdan.simulator.converter.TransactionConverter;
import com.oberdan.simulator.dto.TransactionDto;
import com.oberdan.simulator.entity.Transaction;
import com.oberdan.simulator.repository.TransactionRepository;

@RestController
@RequestMapping("/simulator")
public class SimulatorEndpoint {

	@Autowired
	private TransactionRepository transactionRepository;

	@GetMapping("/transactions/{accountId}")
	public ResponseEntity<?> getAccountTransactions(@PathVariable String accountId) {

		String userName = getUserAuthenticated();
		
		if (!userName.equals(accountId))
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);

		List<Transaction> lista = transactionRepository.findByAccount_accountId(Long.valueOf(accountId), Sort.by(Sort.Direction.DESC, "counterPartyAccountNumber"));

		List<TransactionDto> listaDto = lista.stream()
												.map(dto -> TransactionConverter.getDto(dto))
												.collect(Collectors.toList());

		if (listaDto.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(listaDto, HttpStatus.OK);
	}

	private String getUserAuthenticated() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String userName = "";
		if (principal instanceof UserDetails) {
		  userName = ((UserDetails)principal).getUsername();
		} else {
		  userName = principal.toString();
		}
		return userName;
	}
	
	
	
}
