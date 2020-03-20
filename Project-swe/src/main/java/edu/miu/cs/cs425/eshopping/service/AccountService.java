package edu.miu.cs.cs425.eshopping.service;

import java.util.List;

import edu.miu.cs.cs425.eshopping.model.Account;

public interface AccountService {
	public List<Account> findAll();
	public Account findByUsername(String username);

}
