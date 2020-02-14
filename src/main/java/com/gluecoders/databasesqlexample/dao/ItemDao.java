package com.gluecoders.databasesqlexample.dao;

import com.gluecoders.databasesqlexample.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao extends JpaRepository<Item, Long> {
}
