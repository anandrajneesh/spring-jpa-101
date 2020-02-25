package com.gluecoders.databasesqlexample.transactions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankUserDao extends JpaRepository<BankUser, Long> {
}
