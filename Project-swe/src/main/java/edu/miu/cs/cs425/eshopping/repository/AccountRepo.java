package edu.miu.cs.cs425.eshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.cs.cs425.eshopping.model.Account;

public interface AccountRepo extends JpaRepository<Account, Long> {

}
