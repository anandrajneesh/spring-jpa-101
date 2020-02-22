package com.gluecoders.databasesqlexample.onetoone;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;
    private String city;
    private String street;
    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
