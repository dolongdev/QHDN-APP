package com.qhdn.service.impl;



import com.qhdn.entity.Role;
import com.qhdn.repository.RoleRepo;
import com.qhdn.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepo roleRepo;

	@Override
	public List<Role> findAll() {
		return roleRepo.findAll();
	}

}
