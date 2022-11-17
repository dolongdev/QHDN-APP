package com.qhdn.service.impl;


import com.qhdn.entity.Account;
import com.qhdn.entity.Authority;
import com.qhdn.repository.AccountRepo;
import com.qhdn.repository.AuthorityRepo;
import com.qhdn.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {
	@Autowired
    AuthorityRepo authoritRepo;
	@Autowired
	AccountRepo accountRepo;
	
	@Override
	public List<Authority> findAllAuthorOfAdmin() {
		List<Account> accounts = accountRepo.getAdministrators();
		return authoritRepo.authoritiesOf(accounts);
	}
	@Override
	public List<Authority> findAll() {
		return authoritRepo.findAll();
	}
	@Override
	public Authority create(Authority au) {
		return authoritRepo.save(au);
	}
	@Override
	public void delete(Integer id) {
		authoritRepo.deleteById(id);
		
	}
	


}
