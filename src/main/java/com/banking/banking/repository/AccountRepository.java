package com.banking.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.banking.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
