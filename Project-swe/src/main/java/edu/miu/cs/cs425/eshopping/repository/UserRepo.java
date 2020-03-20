package edu.miu.cs.cs425.eshopping.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.miu.cs.cs425.eshopping.model.User;




@Repository
public interface UserRepo {

	public List<User>findAll();
	public User findByUsername(String username);

}
