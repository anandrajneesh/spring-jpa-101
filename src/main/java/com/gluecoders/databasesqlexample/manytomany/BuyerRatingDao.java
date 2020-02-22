package com.gluecoders.databasesqlexample.manytomany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRatingDao extends JpaRepository<BuyerRating, Long> {
}
