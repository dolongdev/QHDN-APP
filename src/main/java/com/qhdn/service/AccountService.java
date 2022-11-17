package com.qhdn.service;


import com.qhdn.entity.Account;

import java.util.List;

public interface AccountService {

	Account findById(String username);

	public List<Account> getAdministrators();

	public List<Account> findAll();

	void deleteAccount(String username);

	void addAccount(Account account);
	
}
