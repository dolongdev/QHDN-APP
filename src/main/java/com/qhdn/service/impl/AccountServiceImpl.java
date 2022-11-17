package com.qhdn.service.impl;


import com.qhdn.entity.Account;
import com.qhdn.repository.AccountRepo;
import com.qhdn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountRepo accountRepo;
	
	@Override
	public Account findById(String username) {
		return accountRepo.findById(username).get();
	}

	@Override
	public List<Account> getAdministrators() {
		
		return accountRepo.getAdministrators();
	}

	@Override
	public List<Account> findAll() {
		
		return accountRepo.findAll();
	}

	@Override
	public void deleteAccount(String username) {
		this.accountRepo.deleteById(username);
	}

	@Override
	public void addAccount(Account account) {
		this.accountRepo.save(account);
	}

}
