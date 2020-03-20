package edu.miu.cs.cs425.eshopping.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs425.eshopping.model.Account;
import edu.miu.cs.cs425.eshopping.repository.AccountRepo;
import edu.miu.cs.cs425.eshopping.service.AccountSerUserD;

@Service

public class AccountServiceImpleD implements AccountSerUserD {
	
	@Autowired
	private AccountSerImple accountrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Account account = accountrepo.findByUsername(username);
		
		if(account== null) {
			throw new UsernameNotFoundException("Useraneme not found  for " + username);
			
		}
		List<GrantedAuthority>grantedAuthority= new ArrayList<GrantedAuthority>();
				for(String role :account.getRoles()) {
					grantedAuthority.add(new SimpleGrantedAuthority(role));
				}
		
		return new User(account.getUsername(),account.getPassword(),grantedAuthority);

	}

}
