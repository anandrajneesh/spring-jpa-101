package com.gluecoders.databasesqlexample.manytomany;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Buyer {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "buyer",fetch = FetchType.EAGER)
    private Set<BuyerRating> ratings;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BuyerRating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<BuyerRating> ratings) {
        this.ratings = ratings;
    }
}
