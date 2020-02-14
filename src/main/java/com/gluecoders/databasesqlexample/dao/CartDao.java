package com.gluecoders.databasesqlexample.dao;

import com.gluecoders.databasesqlexample.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDao extends JpaRepository<Cart, Long> {
}
