package com.qhdn.service;



import com.qhdn.entity.Authority;

import java.util.List;

public interface AuthorityService {

	public List<Authority> findAllAuthorOfAdmin();

	public	List<Authority> findAll();

	public Authority create(Authority au);

	public void delete(Integer id);



	
}
