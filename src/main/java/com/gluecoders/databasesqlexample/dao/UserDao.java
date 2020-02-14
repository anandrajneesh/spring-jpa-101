package com.gluecoders.databasesqlexample.dao;

import com.gluecoders.databasesqlexample.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
}
