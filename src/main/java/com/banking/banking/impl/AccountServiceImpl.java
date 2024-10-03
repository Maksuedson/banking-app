package com.banking.banking.impl;

import org.springframework.stereotype.Service;

import com.banking.banking.dto.AccountDto;
import com.banking.banking.entity.Account;
import com.banking.banking.mapper.AccountMapper;
import com.banking.banking.repository.AccountRepository;
import com.banking.banking.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	private AccountRepository repo;

	public AccountServiceImpl(AccountRepository repo) {
		this.repo = repo;
	}


	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto);
		Account saveAccount = repo.save(account);
		return AccountMapper.mapToAccountDto(saveAccount);
	}


	@Override
	public AccountDto getAccountById(Long id) {
		
		Account account = repo
		.findById(id)
		.orElseThrow(() -> new RuntimeException("Account does not exists") );
		
		return AccountMapper.mapToAccountDto(account);
	}

}
