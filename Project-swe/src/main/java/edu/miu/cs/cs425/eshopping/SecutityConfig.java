package edu.miu.cs.cs425.eshopping;

import edu.miu.cs.cs425.eshopping.service.CustomerAuthonticationprvd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.miu.cs.cs425.eshopping.repository.AccountRepo;
import edu.miu.cs.cs425.eshopping.service.AccountSerUserD;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecutityConfig extends WebSecurityConfigurerAdapter {

@Autowired
private AccountSerUserD accountSerUserD;

@Autowired
private edu.miu.cs.cs425.eshopping.service.CustomerAuthonticationprvd CustomerAuthonticationprvd;

	
	@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(CustomerAuthonticationprvd).userDetailsService(accountSerUserD);
		
}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.cors()
		.and()
		.csrf()
		.disable()
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();

	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
