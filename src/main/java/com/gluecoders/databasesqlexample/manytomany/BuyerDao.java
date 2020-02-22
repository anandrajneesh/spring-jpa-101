package com.gluecoders.databasesqlexample.manytomany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BuyerDao extends JpaRepository<Buyer, Long> {

    Collection<BuyerProjection> findByName(String name);
}
