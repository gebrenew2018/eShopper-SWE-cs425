package edu.miu.cs.cs425.eshopping.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs425.eshopping.model.Account;
import edu.miu.cs.cs425.eshopping.repository.AccountRepo;
import edu.miu.cs.cs425.eshopping.service.AccountService;

@Service
public class AccountSerImple implements AccountService {

	@Autowired
	private AccountRepo accountrepo;

	@Override
	public List<Account> findAll() { //return list of account 

		return accountrepo.findAll();
	}

	@Override
	public Account findByUsername(String username) { // return account by name; 
		// TODO Auto-generated method stub

		List<Account> accounts = accountrepo.findAll();
		for(Account ac:accounts) {
			if(ac.getUsername().equalsIgnoreCase(username)) {
				return ac;
			}
		}
	
 return null;
	}

}
