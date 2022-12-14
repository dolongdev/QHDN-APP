package com.qhdn.repository;

import com.qhdn.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepo extends JpaRepository<Account, String> {
	@Query("SELECT DISTINCT ar.account FROM Authority ar WHERE ar.role.id IN ('AD')")
	List<Account> getAdministrators();

}
