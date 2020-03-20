package edu.miu.cs.cs425.eshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import ch.qos.logback.core.pattern.color.BoldCyanCompositeConverter;
import edu.miu.cs.cs425.eshopping.repository.AccountRepo;
import edu.miu.cs.cs425.eshopping.service.AccountSerUserD;

@Component
public class CustomerAuthonticationprvd implements AuthenticationProvider  {
	
	@Autowired
	private AccountSerUserD accountrepo;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
String username =authentication.getName();
String password =authentication.getCredentials().toString();

UserDetails user = accountrepo.loadUserByUsername(username);
		if(user== null) {
			throw new UsernameNotFoundException("Username not found ");
		}
		if(!encoder().matches(password,user.getPassword())) {
			throw new UsernameNotFoundException("wrong password  ");
		}
		return  new UsernamePasswordAuthenticationToken(user, password,user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		
		
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
